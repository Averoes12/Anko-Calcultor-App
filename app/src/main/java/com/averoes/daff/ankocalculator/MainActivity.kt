package com.averoes.daff.ankocalculator

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.InputType.TYPE_CLASS_NUMBER
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import org.jetbrains.anko.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //todo 1 membuat parent view untuk menampung edit text

        verticalLayout {

            //todo 2 membuat edit text untuk menerima inputan dari user

            val nilai1 = editText {
                inputType = InputType.TYPE_CLASS_NUMBER
                hint = "Angka Pertama"

            }.lparams {
                width = matchParent
                height = wrapContent
            }

            val nilai2 = editText {
                inputType = InputType.TYPE_CLASS_NUMBER
                hint = "Angka Kedua"

            }.lparams {
                width = matchParent
                height = wrapContent
                bottomMargin = dip(8)
                topMargin = dip(8)
            }
            // todo 3 membuat text view untuk menampilkan hasil

           val hasil =  textView {
                text = "Hasil"
                typeface = Typeface.DEFAULT_BOLD
                textSize = 20f
            }.lparams{
               width = matchParent
               height = wrapContent
               bottomMargin = dip(8)
               leftMargin = dip(8)
           }
            // todo 4 membuat parent view untuk menampung button operator

            linearLayout {
                orientation = LinearLayout.HORIZONTAL

                button {
                    text = "+"

                    setOnClickListener {

                        val angka1 = nilai1.text.toString().toInt()
                        val angka2 = nilai2.text.toString().toInt()

                        hasil.text = (angka1 + angka2).toString()


                    }
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    weight = 1f
                }
                button {
                    text = "-"

                    setOnClickListener {

                        val angka1 = nilai1.text.toString().toInt()
                        val angka2 = nilai2.text.toString().toInt()

                        hasil.text = (angka1 - angka2).toString()
                    }
                }.lparams {
                    weight = 1f
                    width = matchParent
                    height = wrapContent
                }
                button {
                    text = "*"
                    setOnClickListener {

                        val angka1 = nilai1.text.toString().toInt()
                        val angka2 = nilai2.text.toString().toInt()

                        hasil.text = (angka1 * angka2).toString()
                    }
                }.lparams {
                    weight = 1f
                    width = matchParent
                    height = wrapContent
                }
                button {
                    text = "/"

                    setOnClickListener {

                        val angka1 = nilai1.text.toString().toDouble()
                        val angka2 = nilai2.text.toString().toDouble()

                        hasil.text = (angka1 / angka2).toString()
                    }
                }.lparams {
                    width = matchParent
                    weight = 1f
                    height = wrapContent
                }

                button {
                    text = "C"

                    setOnClickListener {

                        nilai1.setText("")
                        nilai2.setText("")
                        hasil.text = "Hasil"
                    }
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    weight = 1f
                }

            }
            //code dibawah ini untuk mengatur padding dari vertical layout yang pertama
        }.padding = dip(16)
    }
}
