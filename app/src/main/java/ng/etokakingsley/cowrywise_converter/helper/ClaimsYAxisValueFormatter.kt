package ng.etokakingsley.cowrywise_converter.helper

import com.github.mikephil.charting.components.AxisBase

import com.github.mikephil.charting.formatter.ValueFormatter


/**
 * @Desc displays values on the Y axis of the chart i.e 1.0USD
 */
class ClaimsYAxisValueFormatter(val symbol : String) : ValueFormatter() {
    override fun getAxisLabel(value: Float, axis: AxisBase): String {
        return value.toString() + symbol
    }
}