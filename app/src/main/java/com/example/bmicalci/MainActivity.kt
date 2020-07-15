package com.example.bmicalci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var weight: EditText
    private lateinit var height: EditText
    private lateinit var result: TextView
    private lateinit var desc: TextView
    private lateinit var btn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weight = findViewById(R.id.etWeight)
        height = findViewById(R.id.etHeight)
        btn = findViewById(R.id.btnCalculate)
        result = findViewById(R.id.tvResult)
        desc = findViewById(R.id.tvdescription)


        btn.setOnClickListener {
            calculateBMI()
        }

    }

    private fun calculateBMI() {
        val strheight = height.text.toString()
        val strweight = weight.text.toString()
        val Height: Float
        val Weight: Float

        if (TextUtils.isEmpty(strheight)) {
            height.error = "Cannot be Empty"
            return
        } else {
            Height = strheight.toFloat()
        }
        if (TextUtils.isEmpty(strweight)) {
            weight.error = "Cannot be Empty"
            return
        } else {
            Weight = strweight.toFloat()
        }
        val bmi = Weight / (Height * Height)
        displaybmi(bmi)
    }

    private fun displaybmi(bmi: Float) {
        var strresult: String
        val des: String

        var bmiLevel: String = when {
            bmi < 16 -> "Severly UnderWeight"
            bmi < 18.25 -> "UnderWeight"
            bmi < 25 -> "Normal"
            bmi < 30 -> "OverWeight"
            else -> "Obese"
        }
        strresult = "$bmi Kg/M2 "
        result.text = strresult

        des = "YOU are $bmiLevel"
        desc.text = des

    }


}
