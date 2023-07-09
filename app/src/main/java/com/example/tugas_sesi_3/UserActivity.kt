package com.example.tugas_sesi_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val textHeaderNama : TextView = findViewById(R.id.textHeaderNama)
        val imageDetailFoto : ImageView = findViewById(R.id.imageDetailFoto)
        val textDetailNama : TextView = findViewById(R.id.textDetailNama)
        val textDetailEmail : TextView = findViewById(R.id.textDetailEmail)
        val textDetailJurusan : TextView = findViewById(R.id.textDetailJurusan)
        val textDetailSemester : TextView = findViewById(R.id.textDetailSemester)

        val bundle : Bundle?= intent.extras
        val headerNama = bundle!!.getString("textHeaderNama")
        val detailFoto = bundle.getInt("imageDetailFoto")
        val detailNama = bundle.getString("textDetailNama")
        val detailEmail = bundle.getString("textDetailEmail")
        val detailJurusan = bundle.getString("textDetailJurusan")
        val detailSemester = bundle.getString("textDetailSemester")

        textHeaderNama.text = headerNama
        imageDetailFoto.setImageResource(detailFoto)
        textDetailNama.text = detailNama
        textDetailEmail.text = detailEmail
        textDetailJurusan.text = detailJurusan
        textDetailSemester.text = detailSemester
    }
}