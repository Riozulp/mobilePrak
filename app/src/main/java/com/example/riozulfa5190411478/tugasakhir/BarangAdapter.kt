package com.example.riozulfa5190411478.tugasakhir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class BarangAdapter(private val barangList: ArrayList<Barang>):
    RecyclerView.Adapter<BarangAdapter.barangViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): barangViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_barang,parent,false)
        return barangViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: barangViewHolder, position: Int) {

        val currentItem = barangList[position]

        holder.nama.text = currentItem.nama
        holder.stok.text = currentItem.stokBrg
        holder.harga.text = currentItem.hrga
    }

    override fun getItemCount(): Int {

        return barangList.size
    }

    class barangViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val nama : TextView = itemView.findViewById(R.id.nama_barang)
        val stok : TextView = itemView.findViewById(R.id.stok)
        val harga : TextView = itemView.findViewById(R.id.harga)

    }

}