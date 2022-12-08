package com.example.exlistview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class viewholder(itemView : View) : RecyclerView.ViewHolder(itemView){
    val BindTextValue : TextView? = itemView.findViewById(R.id.txTitle)
    val BindDesValue : TextView? = itemView.findViewById(R.id.txDescription)
    val BindImgView : ImageView? = itemView.findViewById(R.id.imageView)
    val BindCardView : CardView? = itemView.findViewById(R.id.cardView)
}
