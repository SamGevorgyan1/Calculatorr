package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    lateinit var textResult: TextView
    lateinit var textInput:TextView
    lateinit var buttonNumber1: AppCompatButton
    lateinit var buttonNumber2: AppCompatButton
    lateinit var buttonNumber3: AppCompatButton
    lateinit var buttonNumber4: AppCompatButton
    lateinit var buttonNumber5: AppCompatButton
    lateinit var buttonNumber6: AppCompatButton
    lateinit var buttonNumber7: AppCompatButton
    lateinit var buttonNumber8: AppCompatButton
    lateinit var buttonNumber9: AppCompatButton
    lateinit var buttonNumber0: AppCompatButton
    lateinit var buttonNumber00: AppCompatButton
    lateinit var buttonComma: AppCompatButton
    lateinit var buttonClear: AppCompatButton
    lateinit var buttonPercent: AppCompatButton
    lateinit var buttonBack: AppCompatButton
    lateinit var buttonDivide: AppCompatButton
    lateinit var buttonMultiply: AppCompatButton
    lateinit var buttonMinus: AppCompatButton
    lateinit var buttonPlus: AppCompatButton
    lateinit var buttonEqual: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textResult = findViewById(R.id.textResult)
textInput=findViewById(R.id.textInput)
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

        buttonNumber1.setOnClickListener{set("1")}
        buttonNumber2.setOnClickListener{set("2")}
        buttonNumber3.setOnClickListener{set("3")}
        buttonNumber4.setOnClickListener{set("4")}
        buttonNumber5.setOnClickListener{set("5")}
        buttonNumber6.setOnClickListener{set("6")}
        buttonNumber7.setOnClickListener{set("7")}
        buttonNumber8.setOnClickListener{set("8")}
        buttonNumber9.setOnClickListener{set("9")}
        buttonNumber00.setOnClickListener{set("00")}
        buttonNumber0.setOnClickListener{set("0")}
        buttonComma.setOnClickListener{set(".")}
        buttonPercent.setOnClickListener{set("%")}

        buttonPlus.setOnClickListener{ set("+")}
        buttonMinus.setOnClickListener{set("-")}
        buttonMultiply.setOnClickListener{set("*")}
        buttonDivide.setOnClickListener{set("/")}

        buttonClear.setOnClickListener{
            textResult.text=""
            textInput.text=""
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
    buttonBack.setOnClickListener {
        val number = textInput.text.toString()
        if (number.isNotEmpty())
            textInput.text = number.substring(0, number.length - 1)



}
        }

    fun set(s:String){
        textInput.append(s)

    }
    private fun multiply (s: String): String {

        val lastNumber=s.substringAfterLast("*")
        val firstNumber=s.substringBeforeLast("*")
       val resultMultiply= (lastNumber.toDouble()* firstNumber.toDouble()).toString()
        return resultMultiply
    }
    private fun minus(s:String): String {
        val lastNumber=s.substringAfterLast("-")
        val firstNumber=s.substringBeforeLast("-")
       val resultMinus= (firstNumber.toDouble()- lastNumber.toDouble()).toString()
        return resultMinus
    }
    private fun divide(s:String):String{
        val lastNumber=s.substringAfterLast("/")
        val firstNumber=s.substringBeforeLast("/")
        val resultDivide= (firstNumber.toDouble()/ lastNumber.toDouble()).toString()
        return resultDivide
    }
    private fun plus(s:String):String{
        val lastNumber=s.substringAfterLast("+")
        val firstNumber=s.substringBeforeLast("+")
        val resultPlus= (firstNumber.toDouble()+ lastNumber.toDouble()).toString()
        return resultPlus
    }


}









