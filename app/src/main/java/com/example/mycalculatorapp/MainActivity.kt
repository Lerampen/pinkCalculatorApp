package com.example.mycalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var tvInput: TextView? = null
    var lastNumber : Boolean = false
    var lastDot : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)
    }
    fun onDigit(view: View){
//        Toast.makeText(this, "Button clicked!", Toast.LENGTH_LONG).show()
        tvInput?.append((view as Button).text)
        lastNumber = true
        lastDot = false
    }
    fun clearEverything(view: View){
        tvInput?.text = ""
    }
    fun onDecimalPoint(view: View){
    if (lastNumber  && !lastDot) {
        tvInput?.append(".")
        lastNumber = false
        lastDot = true
    }
    }
    fun onOperator(view: View){
        tvInput?.text?.let {

            if (lastNumber && !isOperatorAdded(it.toString())){
                tvInput?.append((view as Button).text)
                lastNumber = false
                lastDot = false
            }
        }
    }
    private fun isOperatorAdded(value: String) : Boolean{
        return if (value.startsWith("-")) {
            false

        } else {
            (value.contains("/"))|| (value.contains("*"))|| (value.contains("+"))
            (value.contains("-"))
        }
    }
}