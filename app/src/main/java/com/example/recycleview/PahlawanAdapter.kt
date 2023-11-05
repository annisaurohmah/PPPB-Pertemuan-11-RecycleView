package com.example.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.databinding.ItemPahlawanBinding

typealias onClickPahlawan = (Pahlawan) -> Unit

class PahlawanAdapter (private val listPahlawan: List<Pahlawan>, private val
onClickPahlawan: onClickPahlawan):RecyclerView.Adapter<PahlawanAdapter.ItemPahlawanViewHolder>(){
    inner class ItemPahlawanViewHolder(private val binding: ItemPahlawanBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind (data:Pahlawan){
            with(binding){
                itemFotoImage.setImageResource(data.foto_image)
                txtPahlawanName.text = data.namaPahlawan
                txtTglType.text = data.tanggalLahirPahlawan
                txtWafatType.text = data.tanggalWafatPahlawan
                itemView.setOnClickListener{
                    onClickPahlawan(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPahlawanViewHolder {
        val binding = ItemPahlawanBinding.inflate(LayoutInflater.from(
            parent.context), parent, false
        )
        return ItemPahlawanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemPahlawanViewHolder, position: Int) {
        holder.bind(listPahlawan[position])
    }

    override fun getItemCount(): Int = listPahlawan.size
}