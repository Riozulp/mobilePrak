package com.example.riozulfa5190411478.tugasakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class TambahSupplier : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tambah_supplier)

        val kmbl = findViewById<ImageView>(R.id.back)
        kmbl.setOnClickListener {
            startActivity(Intent(this, DaftarSupplier::class.java))
        }
    }
}