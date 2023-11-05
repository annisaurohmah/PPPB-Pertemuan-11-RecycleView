package com.example.recycleview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterPahlawan = PahlawanAdapter(generateDummy()) { pahlawan ->
            Toast.makeText(this@MainActivity,
            "You clicked on ${pahlawan.namaPahlawan}",
            Toast.LENGTH_SHORT).show()
        }
        with(binding) {
            rvPahlawan.apply {
                adapter = adapterPahlawan
                layoutManager = GridLayoutManager(this@MainActivity, 1)
            }
        }
    }
}

fun generateDummy(): List<Pahlawan> {
    return listOf(
        Pahlawan(foto_image = R.drawable.sie, namaPahlawan = "Prof. Mr. Mohammad Yamin, S.H.", tanggalLahirPahlawan = "Kelahiran: 24 Agustus 1903", tanggalWafatPahlawan = "Meninggal: 17 Oktober 1962"),
        Pahlawan(foto_image = R.drawable.sugondo, namaPahlawan = "Sugondo Djojopuspito", tanggalLahirPahlawan = "Kelahiran: 22 Februari 1905", tanggalWafatPahlawan = "Meninggal: 23 April 1978"),
        Pahlawan(foto_image = R.drawable.wage, namaPahlawan = "Wage Rudolf Soepratman", tanggalLahirPahlawan = "Kelahiran: 19 Maret 1903", tanggalWafatPahlawan = "Meninggal: 17 Agustus 1938"),
        Pahlawan(foto_image = R.drawable.amir, namaPahlawan = "Mr. Amir Sjarifoeddin Harahap", tanggalLahirPahlawan = "Kelahiran: 27 April 1907", tanggalWafatPahlawan = "Meninggal: 19 Desember 1948"),
        Pahlawan(foto_image = R.drawable.leimena, namaPahlawan = "Dr. Johannes Leimena", tanggalLahirPahlawan = "Kelahiran: 6 Maret 1905", tanggalWafatPahlawan = "Meninggal: 29 Maret 1977"),
    )
}
