package com.example.tugas_sesi_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class UserAdapter(private val usersList : ArrayList<Users>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private lateinit var userListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position : Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        userListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return UserViewHolder(itemView, userListener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = usersList[position]
        holder.imageFoto.setImageResource(currentItem.imageFoto)
        holder.textNama.text = currentItem.textNama
        holder.textEmail.text = currentItem.textEmail
        holder.textJurusan.text = currentItem.textJurusan
        holder.textSemester.text = currentItem.textSemester
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    class UserViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val imageFoto : ShapeableImageView = itemView.findViewById(R.id.imageFoto)
        val textNama : TextView = itemView.findViewById(R.id.textNama)
        val textEmail : TextView = itemView.findViewById(R.id.textEmail)
        val textJurusan : TextView = itemView.findViewById(R.id.textJurusan)
        val textSemester : TextView = itemView.findViewById(R.id.textSemester)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}