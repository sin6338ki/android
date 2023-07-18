package com.sjy.ex20230718

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MovieActivity : AppCompatActivity() {

    //날짜를 선택하면 날짜에 해당하는 1~10위 리스트 가져오기

    lateinit var btnMovie:Button
    lateinit var lvMovie:ListView
    lateinit var reqQueue:RequestQueue
    val movieList = ArrayList<MovieVO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        //component 가져오기
        btnMovie = findViewById(R.id.btnMovie)
        lvMovie = findViewById(R.id.lvMovie)

        //RequestQueue 생성하기
        reqQueue = Volley.newRequestQueue(this)

        //버튼을 클릭했을 때 영화 API를 통해서 2023.7.17 영화 순위 데이터 요청
        // -> 응답값(순위, 영화제목, 개봉일 -> MovieVO (data class)) 처리
        btnMovie.setOnClickListener {

            val request = StringRequest(
                Request.Method.GET,
                "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20230717",
                {
                    response ->
                    Log.d("response", response.toString())
                    val result = JSONObject(response)
                    val movie = result.getJSONObject("boxOfficeResult").getJSONArray("dailyBoxOfficeList")
                    //영화순위
                    for(i in 0 until movie.length()){
                        val movieItem = movie.get(i) as JSONObject
                        val rank = movieItem.getString("rank")
                        val mvName = movieItem.getString("movieNm")
                        val openDt = movieItem.getString("openDt")
//                        Log.d("순위", rank.toString())
//                        Log.d("영화명", mvName.toString())
//                        Log.d("개봉일", openDt.toString())
                        movieList.add(MovieVO(rank, mvName, openDt))
                        val adaptor = ArrayAdapter<MovieVO>(applicationContext, android.R.layout.simple_list_item_1, movieList)
                        lvMovie.adapter = adaptor
                    }
                },
                {
                    error ->
                    Log.d("error", error.toString())
                    Toast.makeText(this, "error 발생", Toast.LENGTH_SHORT).show()
                }
            )
            reqQueue.add(request)
        }

    }
}