package com.example.riozulfa5190411478.tugasakhir

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.cardview.widget.CardView
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dftr_brg = findViewById<CardView>(R.id.dftrBarang)
        val dftr_supp = findViewById<CardView>(R.id.dftrSupplier)
        val transaksi = findViewById<CardView>(R.id.transaksi)
//        val laporan = findViewById(R.id.laporan) as Button

        dftr_brg.setOnClickListener {
            startActivity(Intent(this, DaftarBarang::class.java))
        }
        dftr_supp.setOnClickListener {
            startActivity(Intent(this, DaftarSupplier::class.java))
        }
        transaksi.setOnClickListener {
            startActivity(Intent(this, DaftarTransaksi::class.java))
        }

    }
}