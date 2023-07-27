package com.sjy.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sjy.fragment.VO.BoardVO

class BoardAdapter(var context: Context, var templete : Int, var data : ArrayList<BoardVO>) : RecyclerView.Adapter<BoardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {

        var item_view : View = LayoutInflater.from(context).inflate(templete, parent, false)
        var VH : BoardViewHolder = BoardViewHolder(item_view)
        return VH
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        val board = data[position]
        holder.tvTitle.text = board.title
        holder.tvWriter.text = board.writer
        var likecnt = holder.tvLikes.toString()
        likecnt = board.likecnt.toString()

    }
}