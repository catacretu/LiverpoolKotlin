package com.example.liverpoolkotlin.adapter

import com.example.liverpoolkotlin.data.local.model.PlayerEntity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.liverpoolkotlin.R

class PlayerAdapter(
    private val playersList: List<PlayerEntity>,
    private val context: Context
): RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
    return ViewHolder(view)
}
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = playersList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return playersList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val name: TextView = itemView.findViewById(R.id.name)
        private val position: TextView = itemView.findViewById(R.id.position)
        private val image: ImageView = itemView.findViewById(R.id.imagePlayer)

        fun bind(item: PlayerEntity){
            name.text = item.name
            position.text = item.position
            Glide.with(context).load(item.imageUrl).into(image)
        }
    }

}