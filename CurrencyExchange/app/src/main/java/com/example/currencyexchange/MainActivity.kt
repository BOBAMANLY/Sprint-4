package com.example.currencyexchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var valueInput : EditText
    private lateinit var valueOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create the buttons
        val quetzalesToDollarsButton = findViewById<Button>(R.id.quetzal_to_dollar)
        val dollarsToQuetzalesButton = findViewById<Button>(R.id.dollar_to_quetzal)
        val resetButton = findViewById<Button>(R.id.reset)

        // value input
        valueInput = findViewById<EditText>(R.id.value_input)
        valueOutput = findViewById<TextView>(R.id.result)

        quetzalesToDollarsButton.setOnClickListener { convertQuetzalesToDollars() }
        dollarsToQuetzalesButton.setOnClickListener { convertDollarsToQuetzales() }
        resetButton.setOnClickListener { reset() }

        }

    private fun convertQuetzalesToDollars() {
        try{
            val quetzales = valueInput.text.toString().toFloat()
            val dollars = quetzales * .13
            valueOutput.text = "${"%.2f".format(dollars)}"
        } catch (e : Exception){
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show()
        }
    }

    private fun convertDollarsToQuetzales() {
        try {
            val dollars = valueInput.text.toString().toFloat()
            val quetzales = dollars * 7.71
            valueOutput.text = "${"%.2f".format(quetzales)}"
        } catch (e: Exception) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show()
        }
    }

    private fun reset() {
        valueInput.text.clear()
        valueOutput.text = ""
    }

}
