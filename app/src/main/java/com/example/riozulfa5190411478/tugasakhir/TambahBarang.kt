package com.example.riozulfa5190411478.tugasakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.riozulfa5190411478.tugasakhir.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase

class TambahBarang : AppCompatActivity() {

    private lateinit var kmbl: ImageView
    private lateinit var idBrg: EditText
    private lateinit var namaBrg: EditText
    private lateinit var stok: EditText
    private lateinit var namaSupp: EditText
    private lateinit var harga: EditText
    private lateinit var simpBrg:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tambah_barang)

        kmbl = findViewById(R.id.back)
        idBrg = findViewById(R.id.Et_idBarang)
        namaBrg = findViewById(R.id.Et_namaBarang)
        stok = findViewById(R.id.Et_stokBarang)
        namaSupp = findViewById(R.id.Et_namaSupplier)
        harga = findViewById(R.id.Et_hargaBarang)
        simpBrg = findViewById(R.id.btn_inputBarang)

        kmbl.setOnClickListener {
            startActivity(Intent(this, DaftarBarang::class.java))
        }

        simpBrg.setOnClickListener {

            val brgId = idBrg.text.toString()
            val nama = namaBrg.text.toString()
            val stokBrg = stok.text.toString()
            val namaSup = namaSupp.text.toString()
            val hrga = harga.text.toString()

            if(brgId.isEmpty() || nama.isEmpty() || stokBrg.isEmpty() || namaSup.isEmpty() || hrga.isEmpty()) {
                Toast.makeText(this, "Data harus diisi semua", Toast.LENGTH_SHORT).show()
            } else{
                val ref = FirebaseDatabase.getInstance().getReference("barang")
                val Barang = Barang(brgId,nama,stokBrg,namaSup,hrga)
                ref.child(nama).setValue(Barang).addOnSuccessListener {
                    idBrg.text.clear()
                    namaBrg.text.clear()
                    stok.text.clear()
                    namaSupp.text.clear()
                    harga.text.clear()

                    Toast.makeText(this, "Berhasil Menambahkan Data Barang",Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Gagal Menambahkan Barang", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}