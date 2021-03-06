package org.crc83.pomodoroplanner.ui.tasks

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.CheckedTextView
import android.widget.TextView
import kotlinx.android.synthetic.main.content_all_tasks_list.*

import org.crc83.pomodoroplanner.R

class AllTasksListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_tasks_list)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        all_tasks_list.adapter = ListExampleAdapter(context = this)

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
        }
		supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }

}

private class ListExampleAdapter(context: Context) : BaseAdapter() {
    internal var sList = arrayOf("One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen")
    private val mInflator: LayoutInflater

    init {
        this.mInflator = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return sList.size
    }

    override fun getItem(position: Int): Any {
        return sList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.row_all_tasks_list, parent, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }

        vh.title?.text = sList[position]
        vh.description?.text = "Lorem ipsum sit"
        return view
    }
}

private class ListRowHolder(row: View?) {
    public val title: CheckedTextView?
    public val description: TextView?

    init {
        this.title = row?.findViewById<CheckedTextView>(R.id.task_title)
        this.description = row?.findViewById<TextView>(R.id.short_description)
    }
}
