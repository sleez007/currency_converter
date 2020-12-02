package ng.etokakingsley.cowrywise_converter.helper

import android.content.Context
import android.widget.TextView
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import ng.etokakingsley.cowrywise_converter.R
import java.text.DateFormat
import java.text.SimpleDateFormat

class MyMarker(context: Context) : MarkerView(context, R.layout.my_marker) {
    val dateView = findViewById<TextView>(R.id.textView11)
    val valueView = findViewById<TextView>(R.id.textView12)

    override fun refreshContent(entry: Entry, highlight: Highlight) {
        super.refreshContent(entry, highlight)
        val f: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        dateView.text = f.format(entry.x.toLong())
        valueView.text = entry.y.toString()
    }
}