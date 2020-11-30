package ng.etokakingsley.cowrywise_converter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import ng.etokakingsley.cowrywise_converter.R
import ng.etokakingsley.cowrywise_converter.model.SpinnerObj


class SpinnerAdapter(val context: Context, val dataSource :List<SpinnerObj>) : BaseAdapter(){
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int = dataSource.size

    override fun getItem(position: Int): Any = dataSource[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: ItemHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.row_currency_selector, parent, false)
            vh = ItemHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemHolder
        }
        vh.label.text = dataSource.get(position).text
        vh.img.setImageResource(dataSource[position].drawable)
        return view
    }

    private class ItemHolder(row: View?) {
        val label: TextView = row?.findViewById(R.id.textView2) as TextView
        val img: ImageView = row?.findViewById(R.id.imageView2) as ImageView
    }

}