package com.sjy.fragment

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BoardViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView){

    lateinit var tvTitle : TextView
    lateinit var tvWriter : TextView
    lateinit var tvLikes : TextView
    lateinit var imgHeart : ImageView

    init {
        tvTitle = itemView.findViewById(R.id.tvTitle)
        tvWriter = itemView.findViewById(R.id.tvWriter)
        tvLikes = itemView.findViewById(R.id.tvLikes)
        imgHeart = itemView.findViewById(R.id.imgHeart)
    }
}