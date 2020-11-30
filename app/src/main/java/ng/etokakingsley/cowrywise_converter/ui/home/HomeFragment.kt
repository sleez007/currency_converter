package ng.etokakingsley.cowrywise_converter.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ng.etokakingsley.cowrywise_converter.R
import ng.etokakingsley.cowrywise_converter.adapter.SpinnerAdapter
import ng.etokakingsley.cowrywise_converter.databinding.FragmentHomeBinding
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
            lifecycleOwner = viewLifecycleOwner
        }
        subscribeUI()
        wireSpinners()
    }

    private fun subscribeUI(){
        homeViewModel.flashSuccessMessage.observe(viewLifecycleOwner){
            it?.getContentIfNotHandled()?.let { msg->
                binding?.let {
                    val snack = SnackBarUtil.successSnack(it.parentLayout, msg, requireContext())
                    snack.show()
                }
            }
        }
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
    }

    private  fun wireSpinners(){
        val toList: ArrayList<SpinnerObj> = ArrayList<SpinnerObj>()
        val fromList: ArrayList<SpinnerObj> = ArrayList<SpinnerObj>()
        fromList.add(SpinnerObj("EUR", R.drawable.ic_european_union))

        toList.add(SpinnerObj("USD", R.drawable.ic_united_states_of_america))
        toList.add(SpinnerObj("AUD", R.drawable.ic_australia))
        toList.add(SpinnerObj("CAD", R.drawable.ic_canada))
        toList.add(SpinnerObj("PLN", R.drawable.ic_republic_of_poland))
        toList.add(SpinnerObj("MXN", R.drawable.ic_mexico))

        binding?.let {
            it.spinner.adapter = SpinnerAdapter(requireContext(), fromList)
            it.spinnerTo.adapter = SpinnerAdapter(requireContext(),toList)
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