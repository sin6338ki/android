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

class WeatherActivity : AppCompatActivity() {

    lateinit var btnWeather:Button
    lateinit var listView: ListView

    lateinit var reqQueue:RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        btnWeather = findViewById(R.id.btnWeather)
        listView = findViewById(R.id.lvWeather)

        //requestQueue 생성
        reqQueue = Volley.newRequestQueue(this)

        //날씨 데이터 가지고오고 싶은 도시 정의 -> 배열
        val cityList = arrayOf("Gwangju", "Seoul", "Jeju-do", "London", "New York")

        //WeatherVO 저장 배열
        val weatherList = ArrayList<WeatherVO>()

        //버튼이 클릭되면 OpenWeatherAPI를 통해 현재 날씨 데이터 요청
        //도시 이름을 배열에 저장 >> 들어있는 도시의 개수만큼 요청이 일어나야함
        btnWeather.setOnClickListener {

            //.. : 끝 값 포함
            //until : 끝 값 포함 X
            //index 마지막 값은 size-1이므로 until을 사용해야 함
            for(i in 0 until  cityList.size){
                val request = StringRequest(
                    Request.Method.GET,
                    "https://api.openweathermap.org/data/2.5/weather?q=${cityList.get(i)}&appid=f074ee48da2e5d5517edac8b232392ec",
                    {
                            response ->
                        Log.d("response", response.toString())
                        val result = JSONObject(response)
                        val weather = result.getJSONArray("weather").get(0) as JSONObject
                        val state = weather.getString("main")
                        val main = result.getJSONObject("main")
                        val temp = main.getInt("temp")

                        //데이터 VO로 묶기
                        //WeatherVO(cityList.get(i), state, temp-273)
                        //생성된 VO는 배열에 저장
                        weatherList.add(WeatherVO(cityList.get(i), state, temp-273))
                        //어댑터 생성 (listView에 뿌려주기 위해)
                        //view에 가지고 온 데이터 적용하기 위해 사용함
                        val adapter = ArrayAdapter<WeatherVO>(applicationContext, android.R.layout.simple_list_item_1, weatherList)
                        //listView에 adaptor 적용
                        listView.adapter = adapter
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
}