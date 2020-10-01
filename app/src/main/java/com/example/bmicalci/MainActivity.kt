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
        desc = findViewById(R.id.tvDescription)


        btn.setOnClickListener {
            calculateBMI()
        }

    }

    private fun calculateBMI() {
        val strHeight = height.text.toString()
        val strWeight = weight.text.toString()
        val height: Float
        val weight: Float

        if (TextUtils.isEmpty(strHeight)) {
            this.height.error = "Cannot be Empty"
            return
        } else {
            height = strHeight.toFloat()
        }
        if (TextUtils.isEmpty(strWeight)) {
            this.weight.error = "Cannot be Empty"
            return
        } else {
            weight = strWeight.toFloat()
        }
        val bmi = weight / (height * height)
        displayBmi(bmi)
    }

    private fun displayBmi(bmi: Float) {
        val des: String

        val bmiLevel: String = when {
            bmi < 16 -> "Severly UnderWeight"
            bmi < 18.25 -> "UnderWeight"
            bmi < 25 -> "Normal"
            bmi < 30 -> "OverWeight"
            else -> "Obese"
        }
        val strResult: String = "$bmi Kg/M2 "
        result.text = strResult

        des = "YOU are $bmiLevel"
        desc.text = des

    }
}