package com.example.tugas_sesi_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Users>
    lateinit var imageId : Array<Int>
    lateinit var textNama : Array<String>
    lateinit var textEmail : Array<String>
    lateinit var textJurusan : Array<String>
    lateinit var textSemester : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.male,
            R.drawable.female,
            R.drawable.male1,
            R.drawable.male2,
            R.drawable.male3,
        )

        textNama = arrayOf(
            "Eka",
            "Dwi",
            "Tri",
            "Catur",
            "Panca"
        )

        textEmail = arrayOf(
            "eka@mail.com",
            "dwi@mail.com",
            "tri@mail.com",
            "catur@mail.com",
            "panca@mail.com"
        )

        textJurusan = arrayOf(
            "Bahasa Indonesia",
            "Ilmu Politik",
            "Teknologi Informasi",
            "Statistika",
            "Kehutanan"
        )

        textSemester = arrayOf(
            "Semester 4",
            "Semester 6",
            "Semester 2",
            "Semester 8",
            "Semester 2"
        )

        newRecyclerView = findViewById(R.id.listPengguna)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Users>()
        getUserData()
    }

    private fun getUserData() {
        for(i in imageId.indices) {
            val users = Users(imageId[i], textNama[i], textEmail[i], textJurusan[i], textSemester[i])
            newArrayList.add(users)
        }

        var adapter = UserAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : UserAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, UserActivity::class.java)
                intent.putExtra("imageDetailFoto", newArrayList[position].imageFoto)
                intent.putExtra("textHeadingNama", newArrayList[position].textNama)
                intent.putExtra("textDetailNama", newArrayList[position].textNama)
                intent.putExtra("textDetailEmail", newArrayList[position].textEmail)
                intent.putExtra("textDetailJurusan", newArrayList[position].textJurusan)
                intent.putExtra("textDetailSemester", newArrayList[position].textSemester)
                startActivity(intent)
            }
        })
    }
}