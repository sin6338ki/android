package com.sjy.ex20230726

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SiteViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView) {

    lateinit var tvSiteNm : TextView
    lateinit var tvSiteAdd : TextView
    lateinit var btnGo : Button

    init{
        tvSiteNm = itemView.findViewById(R.id.tvSiteNm)
        tvSiteAdd = itemView.findViewById(R.id.tvSiteAdd)
        btnGo = itemView.findViewById(R.id.btnGo)
    }
}