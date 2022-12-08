package com.example.exlistview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(private val postList: List<food>, private val context: Context) : RecyclerView.Adapter<viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(context).inflate(R.layout.food_item, parent, false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.BindTextValue!!.text = postList[position].name
        holder.BindDesValue!!.text = postList[position].description
        holder.BindCardView!!.setOnClickListener {
            val intent = Intent(context,DetailActivity:: class.java)
            intent.putExtra("ID",postList[position].id)
            context.startActivities(arrayOf(intent))
        }
        Picasso.get().load(postList[position].image).error(R.mipmap.ic_launcher_round)
            .placeholder(R.mipmap.ic_launcher_round)
            .into(holder.BindImgView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}