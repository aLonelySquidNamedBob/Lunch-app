package com.example.lunch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        itemAdapter = ItemAdapter(mutableListOf())

        rv_items.adapter = itemAdapter
        rv_items.layoutManager = LinearLayoutManager(this)

        fun ChangePrice() {
            var total: Float = 0f
            for (item in itemAdapter.items) {
                total += item.price
            }
            tv_total.text = resources.getString(R.string.total) + " " + total.toString() + "0 €"
        }

        btn_chaud.setOnClickListener {
            val itemTitle = btn_chaud.text.toString()
            val item = Item(itemTitle, resources.getInteger(R.integer.p_chaud)/100.toFloat())
            itemAdapter.AddItem(item)
            ChangePrice()
        }

        btn_sw_ext.setOnClickListener {
            val itemTitle = btn_sw_ext.text.toString()
            val item = Item(itemTitle, resources.getInteger(R.integer.p_sw_ext)/100.toFloat())
            itemAdapter.AddItem(item)
            ChangePrice()
        }

        btn_sw_spe.setOnClickListener {
            val itemTitle = btn_sw_spe.text.toString()
            val item = Item(itemTitle, resources.getInteger(R.integer.p_sw_spe)/100.toFloat())
            itemAdapter.AddItem(item)
            ChangePrice()
        }

        btn_sw_tra.setOnClickListener {
            val itemTitle = btn_sw_tra.text.toString()
            val item = Item(itemTitle, resources.getInteger(R.integer.p_sw_tra)/100.toFloat())
            itemAdapter.AddItem(item)
            ChangePrice()
        }

        btn_sw_lib.setOnClickListener {
            val itemTitle = btn_sw_lib.text.toString()
            val item = Item(itemTitle, resources.getInteger(R.integer.p_sw_lib)/100.toFloat())
            itemAdapter.AddItem(item)
            ChangePrice()
        }

        btn_dessert.setOnClickListener {
            val itemTitle = btn_dessert.text.toString()
            val item = Item(itemTitle, resources.getInteger(R.integer.p_dessert)/100.toFloat())
            itemAdapter.AddItem(item)
            ChangePrice()
        }
    }
}
