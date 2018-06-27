package com.example.temperatureconverterkotlin

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast


class MainActivity : Activity() {
    private var text: EditText? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.inputValue) as EditText

    }

    // this method is called at button click because we assigned the name to the
    // "OnClick" property of the button
    fun onClick(view: View) {
        when (view.id) {
            R.id.button1 -> {
                val celsiusButton = findViewById(R.id.radio0) as RadioButton
                val fahrenheitButton = findViewById(R.id.radio1) as RadioButton
                if (text!!.text.length == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show()
                    return
                }

                val inputValue = java.lang.Float.parseFloat(text!!.text.toString())
                if (celsiusButton.isChecked) {
                    text!!.setText(ConverterUtil.convertFahrenheitToCelsius(inputValue).toString())
                    celsiusButton.isChecked = false
                    fahrenheitButton.isChecked = true
                } else {
                    text!!.setText(ConverterUtil.convertCelsiusToFahrenheit(inputValue).toString())
                    fahrenheitButton.isChecked = false
                    celsiusButton.isChecked = true
                }
            }
        }
    }
}