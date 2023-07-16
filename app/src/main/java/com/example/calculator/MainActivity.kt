package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.notkamui.keval.Keval


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Number buttons
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnZero = findViewById<Button>(R.id.btnZero)
        val btnOne = findViewById<Button>(R.id.btnOne)
        val btnTwo = findViewById<Button>(R.id.btnTwo)
        val btnThree = findViewById<Button>(R.id.btnThree)
        val btnFour = findViewById<Button>(R.id.btnFour)
        val btnFive = findViewById<Button>(R.id.btnFive)
        val btnSix = findViewById<Button>(R.id.btnSix)
        val btnSeven = findViewById<Button>(R.id.btnSeven)
        val btnEight = findViewById<Button>(R.id.btnEight)
        val btnNine = findViewById<Button>(R.id.btnNine)

        // Operation buttons
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val btnEqual = findViewById<Button>(R.id.btnEqual)
        val btnDelete = findViewById<Button>(R.id.btnDelete)

        // Add onClick Event listeners for buttons
        btnClear.setOnClickListener(this)
        btnZero.setOnClickListener(this)
        btnOne.setOnClickListener(this)
        btnTwo.setOnClickListener(this)
        btnThree.setOnClickListener(this)
        btnFour.setOnClickListener(this)
        btnFive.setOnClickListener(this)
        btnSix.setOnClickListener(this)
        btnSeven.setOnClickListener(this)
        btnEight.setOnClickListener(this)
        btnNine.setOnClickListener(this)
        btnPlus.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnDivide.setOnClickListener(this)
        btnEqual.setOnClickListener(this)
        btnDelete.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        val preview = findViewById<TextView>(R.id.preview)
        val previewValue = preview.text.toString()
        val result = findViewById<TextView>(R.id.result)

        when (view.id) {

            R.id.btnClear -> {
                preview.text = ""
                result.text = ""
            }

            R.id.btnZero -> {
                if(previewValue.last().toString() == "/") {
                    Toast.makeText(applicationContext, "Division by zero is not possible", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    preview.text = previewValue.plus("0")
                }
            }

            R.id.btnOne -> {
                preview.text = previewValue.plus("1")
            }

            R.id.btnTwo -> {
                preview.text = previewValue.plus("2")
            }

            R.id.btnThree -> {
                preview.text = previewValue.plus("3")
            }

            R.id.btnFour -> {
                preview.text = previewValue.plus("4")
            }

            R.id.btnFive -> {
                preview.text = previewValue.plus("5")
            }

            R.id.btnSix -> {
                preview.text = previewValue.plus("6")
            }

            R.id.btnSeven -> {
                preview.text = previewValue.plus("7")
            }

            R.id.btnEight -> {
                preview.text = previewValue.plus("8")
            }

            R.id.btnNine -> {
                preview.text = previewValue.plus("9")
            }

            R.id.btnPlus -> {
                if (previewValue == "") {
                    Toast.makeText(applicationContext, "Invalid format used", Toast.LENGTH_SHORT)
                        .show()
                }
                if (previewValue != "" && (previewValue.last()
                        .toString() == "+" || previewValue.last()
                        .toString() == "-" || previewValue.last()
                        .toString() == "x" || previewValue.last()
                        .toString() == "/" || previewValue.last().toString() == ".")
                ) {
                    preview.text = previewValue.dropLast(1).plus("+")
                } else if (previewValue != "") {
                    preview.text = previewValue.plus("+")
                }
            }

            R.id.btnMinus -> {
                if (previewValue == "") {
                    Toast.makeText(applicationContext, "Invalid format used", Toast.LENGTH_SHORT)
                        .show()
                }
                if (previewValue != "" && (previewValue.last()
                        .toString() == "+" || previewValue.last()
                        .toString() == "-" || previewValue.last()
                        .toString() == "x" || previewValue.last()
                        .toString() == "/" || previewValue.last().toString() == ".")
                ) {
                    preview.text = previewValue.dropLast(1).plus("-")
                } else if (previewValue != "") {
                    preview.text = previewValue.plus("-")
                }
            }

            R.id.btnMultiply -> {
                if (previewValue == "") {
                    Toast.makeText(applicationContext, "Invalid format used", Toast.LENGTH_SHORT)
                        .show()
                }
                if (previewValue != "" && (previewValue.last()
                        .toString() == "+" || previewValue.last()
                        .toString() == "-" || previewValue.last()
                        .toString() == "x" || previewValue.last()
                        .toString() == "/" || previewValue.last().toString() == ".")
                ) {
                    preview.text = previewValue.dropLast(1).plus("x")
                } else if (previewValue != "") {
                    preview.text = previewValue.plus("x")
                }
            }

            R.id.btnDivide -> {
                if (previewValue == "") {
                    Toast.makeText(applicationContext, "Invalid format used", Toast.LENGTH_SHORT)
                        .show()
                }
                if (previewValue != "" && (previewValue.last()
                        .toString() == "+" || previewValue.last()
                        .toString() == "-" || previewValue.last()
                        .toString() == "x" || previewValue.last()
                        .toString() == "/" || previewValue.last().toString() == ".")
                ) {
                    preview.text = previewValue.dropLast(1).plus("/")
                } else if (previewValue != "") {
                    preview.text = previewValue.plus("/")
                }
            }

            R.id.btnDelete -> {
                preview.text = previewValue.dropLast(1)
            }

            R.id.btnEqual -> {
               val finalExpression = previewValue.replace("x","*")
               val finalResult = Keval.eval(finalExpression)
               result.text = finalResult.toString()
               preview.text = ""
            }
        }

    }


}
