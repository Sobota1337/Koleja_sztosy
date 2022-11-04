package com.barstool.zadanie_na_algorytmike_28102022

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.LinkedList
import java.util.Queue

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val StosDodaj = findViewById<Button>(R.id.btnDodajStos)
        val StosUsun = findViewById<Button>(R.id.btnUsunStos)
        val OstElementand1 = findViewById<Button>(R.id.btnOstStos)
        val napis = findViewById<TextView>(R.id.napis2)
        var liczby = LinkedList<Int>();
        val Wprowadzaniestos = findViewById<EditText>(R.id.stosWpisz)
        StosDodaj.setOnClickListener {
            if(Wprowadzaniestos.text.toString() != ""){
                if (liczby.isEmpty()){
                    StosUsun.isEnabled = true
                    liczby.addFirst(Wprowadzaniestos.text.toString().toInt())
                    napis.text = liczby.first.toString()
                }
                else {
                    liczby.add(Wprowadzaniestos.text.toString().toInt())
                    napis.text = liczby.last.toString()
                }
            }
            else{
                Toast.makeText(baseContext, "Podaj jakas ilosc", Toast.LENGTH_SHORT).show()
            }
        }
        StosUsun.setOnClickListener {
                liczby.removeLast()
                if(liczby.isEmpty()){
                    napis.text = ""
                    StosUsun.isEnabled = false
                }
                else{
                    napis.text = liczby.last.toString()
                }
        }
        OstElementand1.setOnClickListener {
            if (liczby.isEmpty()){
                Toast.makeText(baseContext, "Nie ma", Toast.LENGTH_SHORT).show()
            }
            else{
                napis.text = liczby.last.toString() + " " + liczby.first.toString()

            }
        }
        /**----------------------KOLEJKA---------------------**/
        val kolejka: Queue<Int> = LinkedList<Int>()
        val KolejkaDodaj = findViewById<Button>(R.id.btnDodajKolejka)
        val KolejkaUsun = findViewById<Button>(R.id.btnUsunKolejka)
        val KolejkaZawartosc = findViewById<Button>(R.id.btnZawartoscKolejka)
        val Kolejka1element = findViewById<Button>(R.id.btnKolejka1)
        val wprowadzanieKolejka = findViewById<EditText>(R.id.KolejkaWpisz)
        val napiss = findViewById<TextView>(R.id.napis3)

        KolejkaZawartosc.setOnClickListener {
            napiss.text = kolejka.toString()
        }
        Kolejka1element.setOnClickListener {
            var pierwszy = kolejka.peek()
            napiss.text = pierwszy.toString()
        }
        KolejkaDodaj.setOnClickListener {
            kolejka.add(wprowadzanieKolejka.text.toString().toInt())
        }
        KolejkaUsun.setOnClickListener {
            kolejka.poll()
        }
    }
}