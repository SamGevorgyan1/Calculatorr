package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {


    private lateinit var textResult: TextView
    private lateinit var textInput: TextView
    private lateinit var buttonNumber1: AppCompatButton
    private lateinit var buttonNumber2: AppCompatButton
    private lateinit var buttonNumber3: AppCompatButton
    private lateinit var buttonNumber4: AppCompatButton
    private lateinit var buttonNumber5: AppCompatButton
    private lateinit var buttonNumber6: AppCompatButton
    private lateinit var buttonNumber7: AppCompatButton
    private lateinit var buttonNumber8: AppCompatButton
    private lateinit var buttonNumber9: AppCompatButton
    private lateinit var buttonNumber0: AppCompatButton
    private lateinit var buttonNumber00: AppCompatButton
    private lateinit var buttonComma: AppCompatButton
    private lateinit var buttonClear: AppCompatButton
    private lateinit var buttonPercent: AppCompatButton
    private lateinit var buttonBack: AppCompatButton
    private lateinit var buttonDivide: AppCompatButton
    private lateinit var buttonMultiply: AppCompatButton
    private lateinit var buttonMinus: AppCompatButton
    private lateinit var buttonPlus: AppCompatButton
    private lateinit var buttonEqual: AppCompatButton
    private var buttonPressed: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textResult = findViewById(R.id.textResult)
        textInput = findViewById(R.id.textInput)
        buttonNumber1 = findViewById(R.id.buttonNumber1)
        buttonNumber2 = findViewById(R.id.buttonNumber2)
        buttonNumber3 = findViewById(R.id.buttonNumber3)
        buttonNumber4 = findViewById(R.id.buttonNumber4)
        buttonNumber5 = findViewById(R.id.buttonNumber5)
        buttonNumber6 = findViewById(R.id.buttonNumber6)
        buttonNumber7 = findViewById(R.id.buttonNumber7)
        buttonNumber8 = findViewById(R.id.buttonNumber8)
        buttonNumber9 = findViewById(R.id.buttonNumber9)
        buttonNumber0 = findViewById(R.id.buttonNumber0)
        buttonNumber00 = findViewById(R.id.buttonNumber00)
        buttonComma = findViewById(R.id.buttonComma)

        buttonClear = findViewById(R.id.buttonClear)
        buttonPercent = findViewById(R.id.buttonPercent)
        buttonBack = findViewById(R.id.buttonBack)
        buttonDivide = findViewById(R.id.buttonDivide)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonMinus = findViewById(R.id.buttonMinus)
        buttonPlus = findViewById(R.id.buttonPlus)
        buttonEqual = findViewById(R.id.buttonEqual)

        buttonNumber1.setOnClickListener { setNumber("1") }
        buttonNumber2.setOnClickListener { setNumber("2") }
        buttonNumber3.setOnClickListener { setNumber("3") }
        buttonNumber4.setOnClickListener { setNumber("4") }
        buttonNumber5.setOnClickListener { setNumber("5") }
        buttonNumber6.setOnClickListener { setNumber("6") }
        buttonNumber7.setOnClickListener { setNumber("7") }
        buttonNumber8.setOnClickListener { setNumber("8") }
        buttonNumber9.setOnClickListener { setNumber("9") }
        buttonNumber0.setOnClickListener { setNumber("0") }

        buttonNumber00.setOnClickListener {
            if (!textInput.text.toString().equals("")){
                setNumber("00")
            }
        }

        buttonComma.setOnClickListener {
            Toast.makeText(this, "still not working", Toast.LENGTH_SHORT).show()
        }
        buttonPercent.setOnClickListener {
            Toast.makeText(this, "still not working", Toast.LENGTH_SHORT).show()
        }

        buttonPlus.setOnClickListener { setSign(textInput,"+") }
        buttonMinus.setOnClickListener {setSign(textInput,"-")}
        buttonMultiply.setOnClickListener {setSign(textInput,"*")}
        buttonDivide.setOnClickListener {setSign(textInput,"/")}


        buttonClear.setOnClickListener {
            textResult.text = ""
            textInput.text =null
        }

        buttonBack.setOnClickListener {
            val number = textInput.text.toString()
            if (number.isNotEmpty())
                textInput.text = number.substring(0, number.length - 1)
        }

        buttonEqual.setOnClickListener {

            if (textInput.text.toString().contains('*')) {
                val r = multiply(textInput.text.toString())
                textResult.text = r
            }
            if (textInput.text.toString().contains('-')) {
                val r = minus(textInput.text.toString())
                textResult.text = r
            }
            if (textInput.text.toString().contains('+')) {
                val r = plus(textInput.text.toString())
                textResult.text = r
            }
            if (textInput.text.toString().contains('/')) {
                val r = divide(textInput.text.toString())
                textResult.text = r
            }
        }
    }

    private fun setNumber(s: String) {
        checkUserInput(textInput, "0")
        textInput.append(s)

    }
    private fun setSign(textView: TextView, sign:String){
        checkUserInput(textInput, "*")
        checkUserInput(textInput, "+")
        checkUserInput(textInput, "/")
        checkUserInput(textInput, "-")
        if (!textView.text.toString().equals("")){
            textView.append(sign)
        }
    }

    private fun multiply(s: String): String {
        val lastNumber = s.substringAfterLast("*")
        val firstNumber = s.substringBeforeLast("*")
        val resultMultiply = (lastNumber.toDouble() * firstNumber.toDouble()).toString()
        return resultMultiply
    }

    private fun minus(s: String): String {
        val lastNumber = s.substringAfterLast("-")
        val firstNumber = s.substringBeforeLast("-")
        val resultMinus = (firstNumber.toDouble() - lastNumber.toDouble()).toString()
        return resultMinus
    }

    private fun divide(s: String): String {
        val lastNumber = s.substringAfterLast("/")
        val firstNumber = s.substringBeforeLast("/")
        val resultDivide = (firstNumber.toDouble() / lastNumber.toDouble()).toString()
        return resultDivide
    }

    private fun plus(s: String): String {
        val lastNumber = s.substringAfterLast("+")
        val firstNumber = s.substringBeforeLast("+")
        val resultPlus = (firstNumber.toDouble() + lastNumber.toDouble()).toString()
        return resultPlus
    }

    private fun checkUserInput(textView: TextView, value: String) {
        val text = textView.text.toString()
        var a = 1..9
        if (text.take(1) == value) {
            textView.text = null
        }

        if (textView.text.contains("//")
            || textView.text.contains("**")
            ||textView.text.contains("++")
            ||textView.text.contains("--")
            ||textView.text.contains("-+")
            ||textView.text.contains("+-")
            ||textView.text.contains("+*")
            ||textView.text.contains("*+")
            ||textView.text.contains("+/")
            ||textView.text.contains("/+")
            ||textView.text.contains("/*")
            ||textView.text.contains("*/")
            ||textView.text.contains("/-")
            ||textView.text.contains("-/")
            ||textView.text.contains("*-")
            ||textView.text.contains("-*")

        ) {
            textInput.text = text.substring(0, text.length - 1)
        }
    }
}











