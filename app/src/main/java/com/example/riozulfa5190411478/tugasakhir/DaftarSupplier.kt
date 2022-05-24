package com.example.riozulfa5190411478.tugasakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class DaftarSupplier : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daftar_supplier)

        val kmbl = findViewById<ImageView>(R.id.back)
        val tmbh = findViewById<Button>(R.id.btn_tambahSupplier)
        kmbl.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        tmbh.setOnClickListener {
            startActivity(Intent(this, TambahSupplier::class.java))
        }
    }
}