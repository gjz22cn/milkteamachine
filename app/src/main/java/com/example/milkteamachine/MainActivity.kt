package com.example.milkteamachine

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    // fruitList用于存储数据
    private val milkTeaList: MutableList<MilkTea> = ArrayList<MilkTea>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        // 配方设置按钮
        var formulaBtn =findViewById<Button>(R.id.btn_formula)
        formulaBtn.setOnClickListener{
            var intent = Intent(this@MainActivity, FormulaActivity::class.java)
            startActivity(intent)
        }

        // 先拿到数据并放在适配器上
        initMilkTeas() //初始化数据
        val adapter = MilkTeaAdapter(this@MainActivity, R.layout.milktea_list_item, milkTeaList)

        // 将适配器上的数据传递给listView
        val listView = findViewById<ListView>(R.id.milktea_list_view)
        listView.adapter = adapter

        // 为ListView注册一个监听器，当用户点击了ListView中的任何一个子项时，就会回调onItemClick()方法
        // 在这个方法中可以通过position参数判断出用户点击的是那一个子项
        listView.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                val milkTea: MilkTea = milkTeaList[position]
                Toast.makeText(this@MainActivity, milkTea.getName(), Toast.LENGTH_SHORT).show()
            }


    }

    // 初始化数据
    private fun initMilkTeas() {
        for (i in 0..8) {
            val a = MilkTea("茉莉绿", "特大杯", "0")
            milkTeaList.add(a)
            val b = MilkTea("观音红", "大杯", "3分")
            milkTeaList.add(b)
            val c = MilkTea("果茶", "中杯", "5分")
            milkTeaList.add(c)
            val d = MilkTea("牛奶", "小杯", "7分")
            milkTeaList.add(d)
        }
    }
}
