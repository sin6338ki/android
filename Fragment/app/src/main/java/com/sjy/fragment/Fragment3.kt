package com.sjy.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.sjy.fragment.VO.BoardVO
import org.json.JSONArray

class Fragment3 : Fragment() {

    lateinit var reqQueue : RequestQueue
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_3, container, false)

        var rcBoard : RecyclerView = view.findViewById(R.id.rcBoard)
        var btnWriteAct : Button = view.findViewById(R.id.btnWriteAct)

        reqQueue = Volley.newRequestQueue(requireActivity())

        var posts = ArrayList<BoardVO>()
        
//        posts.add(BoardVO("1", "test1", "안녕", "id1", null, 10))
//        posts.add(BoardVO("2", "test2", "안녕", "id2", null, 6))
//        posts.add(BoardVO("3", "test3", "안녕", "id3", null, 16))
//        posts.add(BoardVO("4", "test4", "안녕", "id4", null, 18))
//        posts.add(BoardVO("5", "test5", "안녕", "id5", null, 30))
//        posts.add(BoardVO("6", "test6", "안녕", "id6", null, 30))

        val request = object : StringRequest(
            Request.Method.GET,
            "http://172.30.1.42:8888/board",
            {
                response ->
//                Log.d("response", response.toString())
                var result = JSONArray(response)
                for(i in 0 until result.length()){
                    val bvo : BoardVO = Gson().fromJson(result.getJSONObject(i).toString(), BoardVO::class.java)
                    posts.add(bvo)
                }
                var adapter : BoardAdapter = BoardAdapter(view.context, R.layout.board_item, posts)
                rcBoard.layoutManager = LinearLayoutManager(requireActivity())
                rcBoard.adapter = adapter
            },
            {
                error ->
                Log.d("error", error.toString())
            }
        ){}
        reqQueue.add(request)

        return view
    }
}