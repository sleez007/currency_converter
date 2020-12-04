package ng.etokakingsley.cowrywise_converter.ui.home

import android.graphics.Color
import android.graphics.DashPathEffect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis.XAxisPosition
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import ng.etokakingsley.cowrywise_converter.MainActivity
import ng.etokakingsley.cowrywise_converter.R
import ng.etokakingsley.cowrywise_converter.adapter.SpinnerAdapter
import ng.etokakingsley.cowrywise_converter.databinding.FragmentHomeBinding
import ng.etokakingsley.cowrywise_converter.db.entities.Rate
import ng.etokakingsley.cowrywise_converter.helper.ClaimsXAxisValueFormatter
import ng.etokakingsley.cowrywise_converter.helper.ClaimsYAxisValueFormatter
import ng.etokakingsley.cowrywise_converter.helper.MyMarker
import ng.etokakingsley.cowrywise_converter.helper.SnackBarUtil
import ng.etokakingsley.cowrywise_converter.model.SpinnerObj
import java.util.*


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private  val homeViewModel: HomeViewModel by viewModels()
    var binding : FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding?.apply {
            vm = homeViewModel
            imageView4.setOnClickListener {
                (activity as MainActivity).drawer_layout.openDrawer(GravityCompat.START)
            }
            lifecycleOwner = viewLifecycleOwner
        }
        subscribeUI()
        wireSpinners()
    }

    /***
     * Method registers watchers or observers for livedata update
     */
    private fun subscribeUI(){
        //This observer emits a success message when their is a success message from API call and pops a snackbar
        homeViewModel.flashSuccessMessage.observe(viewLifecycleOwner){
            it?.getContentIfNotHandled()?.let { msg->
                binding?.let {
                    val snack = SnackBarUtil.successSnack(it.parentLayout, msg, requireContext())
                    snack.show()
                }
            }
        }

        //This observer emits a error message when their is a success message from API call and pops a snackbar
        homeViewModel.flashErrorMessage.observe(viewLifecycleOwner){
            it?.getContentIfNotHandled()?.let { msg->
                binding?.let {
                    val snack = SnackBarUtil.errorSnack(
                        view = it.parentLayout,
                        msg = msg,
                        requireContext()
                    )
                    snack.show()
                }
            }
        }

        //This observer emits the rates for selected currency to be plotted on the graph
        homeViewModel.rates.observe(viewLifecycleOwner){
            it?.let {
                wireChart(it)
            }
        }
    }

    /**
     * @desc Populate the spinner with items and also handles spinner item selected event
     */
    private  fun wireSpinners(){
        val toList: ArrayList<SpinnerObj> = ArrayList<SpinnerObj>()
        val fromList: ArrayList<SpinnerObj> = ArrayList<SpinnerObj>()
        fromList.add(SpinnerObj("EUR", R.drawable.ic_european_union))

        toList.add(SpinnerObj("PLN", R.drawable.ic_republic_of_poland))
        toList.add(SpinnerObj("NGN", R.drawable.ic_nigeria))
        toList.add(SpinnerObj("USD", R.drawable.ic_united_states_of_america))
        toList.add(SpinnerObj("AUD", R.drawable.ic_australia))
        toList.add(SpinnerObj("CAD", R.drawable.ic_canada))
        toList.add(SpinnerObj("MXN", R.drawable.ic_mexico))

        binding?.let {
            it.spinner.adapter = SpinnerAdapter(requireContext(), fromList)
            it.spinnerTo.adapter = SpinnerAdapter(requireContext(), toList)
            it.spinnerTo.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    homeViewModel.switchCurrency(toList[position].text)
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {}

            }
        }
    }

    /**
     * @desc This method setups data to be displayed on the chart
     */
    private fun wireChart(rateList: List<Rate>){
        binding?.let {
            val xAxisLabel: ArrayList<String> = ArrayList()
            xAxisLabel.add("1")
            xAxisLabel.add("7")
            xAxisLabel.add("14")
            xAxisLabel.add("21")
            xAxisLabel.add("28")
            xAxisLabel.add("30")

            val xAxis = it.chart1.xAxis
            val position = XAxisPosition.BOTTOM
            xAxis.position = position
            xAxis.enableGridDashedLine(2f, 7f, 0f)
            xAxis.axisMaximum = 5f
            xAxis.axisMinimum = 0f
            xAxis.setLabelCount(6, true)
            xAxis.isGranularityEnabled = true
            xAxis.granularity = 7f
            xAxis.labelRotationAngle = 315f
            val dates = rateList.map {
                it.date
            }
            xAxis.valueFormatter = ClaimsXAxisValueFormatter(dates);
            xAxis.setCenterAxisLabels(true);
            xAxis.setDrawLimitLinesBehindData(true);

            val cal =Calendar.getInstance().timeInMillis
            val ll1 = LimitLine(cal.toFloat(), cal.toString())
            ll1.lineColor = ContextCompat.getColor(requireContext(), R.color.brand_green)
            ll1.lineWidth = 4f
            ll1.enableDashedLine(10f, 10f, 0f)
            ll1.labelPosition = LimitLine.LimitLabelPosition.RIGHT_BOTTOM
            ll1.textSize = 10f

            val ll2 = LimitLine(35f, "")
            ll2.lineWidth = 4f
            ll2.enableDashedLine(10f, 10f, 0f)
            ll2.labelPosition = LimitLine.LimitLabelPosition.RIGHT_BOTTOM
            ll2.textSize = 10f
            ll2.lineColor = Color.parseColor("#FFFFFF")

            xAxis.removeAllLimitLines()
            xAxis.addLimitLine(ll1)
            xAxis.addLimitLine(ll2)

            val leftAxis = it.chart1.axisLeft
            leftAxis.removeAllLimitLines()
           // leftAxis.axisMaximum = 1 + 100f
            val minVal  = rateList.minByOrNull { it.rate }
            leftAxis.axisMinimum = minVal?.rate?.toFloat() ?: 0f
            leftAxis.enableGridDashedLine(10f, 10f, 0f)
            leftAxis.setDrawZeroLine(false)
            leftAxis.setDrawLimitLinesBehindData(false)
            leftAxis.valueFormatter = ClaimsYAxisValueFormatter(homeViewModel.initialTo.value ?:"")

            it.chart1.description.isEnabled = false
//            val description = Description()
//            description.text = "Week";
            ////description.textSize = 15f;
           // it.chart1.description.setPosition(0f, 0f);
           // it.chart1.description = description;
            it.chart1.axisRight.isEnabled = false


            //Enable Zoom in and out
            it.chart1.setTouchEnabled(true)
            it.chart1.setPinchZoom(false)

            setDataForWeeksWise(rateList);
        }
    }

    private fun setDataForWeeksWise(rates: List<Rate>){
        var i =0;
        val values: List<Entry> = rates.map {
            Entry(
                (++i).toFloat(),
                it.rate.toFloat()
            )
        }

        var set1 : LineDataSet
        binding?.let {
            if(it.chart1.data != null && it.chart1.data.dataSetCount >0){
                set1 = it.chart1.data.getDataSetByIndex(0) as LineDataSet
                set1.values = values
                it.chart1.data.notifyDataChanged()
                it.chart1.notifyDataSetChanged()
                val mk = MyMarker(requireContext())
                mk.chartView=it.chart1
                it.chart1.marker = mk
                it.chart1.invalidate()
            }else{
                set1 = LineDataSet(values, "Currency rate")
                set1.setDrawCircles(true)
                set1.enableDashedLine(10f, 0f, 0f)
                set1.enableDashedHighlightLine(10f, 0f, 0f)
                set1.color = ContextCompat.getColor(requireContext(), R.color.brand_green)
                set1.setCircleColor(ContextCompat.getColor(requireContext(), R.color.brand_green))
                set1.lineWidth = 2f //line size

                set1.circleRadius = 5f
                set1.setDrawCircleHole(true)
                set1.valueTextSize = 10f
                set1.setDrawFilled(true)
                set1.formLineWidth = 5f
                set1.formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
                set1.formSize = 5f
                set1.fillColor = Color.WHITE;

                set1.setDrawValues(true)
                val dataSets: ArrayList<ILineDataSet> = ArrayList()
                dataSets.add(set1)
                val data = LineData(dataSets)
                it.chart1.data = data
                val mk = MyMarker(requireContext())
                mk.chartView=it.chart1
                it.chart1.marker = mk
                it.chart1.invalidate()
            }
        }
    }

    /**
     * Null out the bindings to avoid memory leaks
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}