package ng.etokakingsley.cowrywise_converter.helper

import android.content.Context
import android.widget.TextView
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import ng.etokakingsley.cowrywise_converter.R
import timber.log.Timber
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MyMarker(context: Context) : MarkerView(context, R.layout.my_marker) {
    private val valueView = findViewById<TextView>(R.id.textView12)

    override fun refreshContent(entry: Entry, highlight: Highlight) {
        super.refreshContent(entry, highlight)
        valueView.text = entry.y.toString()
    }
}