package com.example.tablex

import android.R
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.tablex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.seekbaar.max=20
        binding.seekbaar.min=1
        fetchTable(1)
        binding.seekbaar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    fetchTable(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

    }
    @SuppressLint("SetTextI18n")
    private fun fetchTable(number:Int){
        val table=ArrayList<String>()
        for (i in 1..10){
            table.add("$number X $i = ${i*number}")
        }
        binding.text.text="Table of $number"
       val adapter=ArrayAdapter(this, R.layout.simple_list_item_1,table)
        binding.table.adapter=adapter
    }
}