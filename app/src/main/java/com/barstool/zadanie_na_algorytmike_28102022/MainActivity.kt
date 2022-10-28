package com.barstool.zadanie_na_algorytmike_28102022

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.LinkedList

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val StosDodaj = findViewById<Button>(R.id.btnDodajStos)
        val StosUsun = findViewById<Button>(R.id.btnUsunStos)
        val napis = findViewById<TextView>(R.id.napis2)
        var liczby = LinkedList<Int>();
        val Wprowadzaniestos = findViewById<EditText>(R.id.stosWpisz)
        StosDodaj.setOnClickListener {
            if (liczby.isEmpty()){
                liczby.addFirst(Wprowadzaniestos.text.toString().toInt())
                napis.text = liczby.first.toString()
            }
            else {
                liczby.add(Wprowadzaniestos.text.toString().toInt())
                napis.text = liczby.last.toString()
            }
        }
        StosUsun.setOnClickListener {
            if (liczby.isEmpty()){
                StosUsun.isEnabled = false
            }
            else{
                liczby.removeLast()
                if(liczby.isEmpty()){
                    napis.text = ""
                }
                else{
                    napis.text = liczby.last.toString()
                }

            }
        }
    }
}