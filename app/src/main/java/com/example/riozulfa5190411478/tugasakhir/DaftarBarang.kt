package com.example.riozulfa5190411478.tugasakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class DaftarBarang : AppCompatActivity() {

    private lateinit var kmbl: ImageView
    private lateinit var tmbh: Button
    private lateinit var dbref: DatabaseReference
    private lateinit var barangRecyclerView: RecyclerView
    private lateinit var barangArrayList: ArrayList<Barang>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daftar_barang)

        kmbl = findViewById(R.id.back)
        tmbh = findViewById(R.id.btn_tambahBarang)

        kmbl.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        tmbh.setOnClickListener {
            startActivity(Intent(this, TambahBarang::class.java))
        }

        barangRecyclerView = findViewById(R.id.rv_brg)
        barangRecyclerView.layoutManager = LinearLayoutManager(this)
        barangRecyclerView.setHasFixedSize(true)

        barangArrayList= arrayListOf<Barang>()
        getBarangData()
    }

    private fun getBarangData() {

        dbref = FirebaseDatabase.getInstance().getReference("barang")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (barangSnapshot in snapshot.children){
                        val brg = barangSnapshot.getValue(Barang::class.java)
                        barangArrayList.add(brg!!)
                    }
                    barangRecyclerView.adapter = BarangAdapter(barangArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }
}