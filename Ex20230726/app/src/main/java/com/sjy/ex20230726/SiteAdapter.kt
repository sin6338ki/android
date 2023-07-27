package com.sjy.ex20230726

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SiteAdapter(var context: Context, var templete:Int, var data:ArrayList<SiteVO>) : RecyclerView.Adapter<SiteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiteViewHolder {

        var item_view : View = LayoutInflater.from(context).inflate(templete, parent, false)
        var VH : SiteViewHolder = SiteViewHolder(item_view)

        return VH
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SiteViewHolder, position: Int) {
        val site = data[position]
        holder.tvSiteNm.text = site.siteNm
        holder.tvSiteAdd.text = site.siteAdd

        //버튼 클릭시 사이트 이동
        holder.btnGo.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(site.siteAdd.toString()) )
            //Activity가 아닌 곳에서 Intent를 실행시키고 싶을 때
            //새로운 태스크를 생성해야 함!
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}