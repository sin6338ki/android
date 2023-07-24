package com.sjy.pokemon

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.isVisible
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONObject
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {

    lateinit var ivPokemon : ImageView
    lateinit var tvName : TextView
    lateinit var tvType1 : TextView
    lateinit var tvType2 : TextView
    lateinit var tvHeight : TextView
    lateinit var tvWeight : TextView
    lateinit var tblRow : TableRow
    lateinit var reqQueue : RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //component 가져오기 -> 이미지, 텍스트
        ivPokemon = findViewById(R.id.ivDetailPokemon)
        tvName = findViewById(R.id.tvPokeName)
        tvType1 = findViewById(R.id.tvType1)
        tvType2 = findViewById(R.id.tvType2)
        tvHeight = findViewById(R.id.tvHeight)
        tvWeight = findViewById(R.id.tvWeight)
        tblRow = findViewById(R.id.tblRow)

        reqQueue = Volley.newRequestQueue(this)

        //intent -> 이름, 이미지경로(Glide), id(상세 정보 가져올 때 사용)
        //상세정보 url : https://pokeapi.co/api/v2/pokemon/$id
        val intent : Intent = intent
        var id : Int = intent.getIntExtra("id", -1)
        var imgUrl : String? = intent.getStringExtra("imgUrl")
        var name : String? = intent.getStringExtra("name")

        //response -> JSONObject 형태로 변환 -> result
        //2번째 타입 없는 경우가 있음 ! >> 주의
        //type = result.getJSONArray("types")
        //type.getJSONObject(index).getJSONObject("type").getString("name")
        //                  index -> 0,1 (1번째 없을 수 있음) 어떻게 처리할건지 생각

        //result.getDouble("weight") 무게
        //result.getDouble("height") 크기

        val request = object : StringRequest(
            Request.Method.GET,
            "https://pokeapi.co/api/v2/pokemon/$id",
            {
                response ->
//                Log.d("response", response.toString())
                val result = JSONObject(response)
                val type = result.getJSONArray("types")
                var type1 : String = ""
                var type2 : String = ""

                type1 = type.getJSONObject(0).getJSONObject("type").getString("name")
                if(type.length()==1){
                    tblRow.visibility = View.GONE
                }else{
                    type2 = type.getJSONObject(1).getJSONObject("type").getString("name")
                }

                val weight = result.getDouble("weight")
                val height = result.getDouble("height")

                Glide.with(this).load(imgUrl).into(ivPokemon)
                tvName.text = name

                tvType1.text = type1
                tvType2.text = type2
                tvWeight.text = weight.toString() + "kg"
                tvHeight.text = height.toString() + "m"

//                val typeList = arrayOf("normal", "fire", "water", "grass", "electric", "ice", "poison", "bug")
                //HashMap

                val typeList = HashMap<String, Int>()
                typeList.put("electric", Color.rgb(255,255,102))
                typeList.put("water", Color.rgb(153,255,255))
                typeList.put("fire", Color.rgb(204,0,0))
                typeList.put("grass", Color.rgb(51,255,102))
                typeList.put("poison", Color.rgb(153,0,204))
                typeList.put("bug", Color.rgb(51,102,102))
                typeList.put("ice", Color.rgb(102,204,255))
                typeList.put("ground", Color.rgb(153,102,0))
                typeList.put("rock", Color.rgb(51,51,51))
                typeList.put("normal", Color.rgb(0,0,0))

                typeList.get(type1)?.let { ivPokemon.setBackgroundColor(it) }
            },
            {
                error ->
                Log.d("error", error.toString())
            }
        ){}
        reqQueue.add(request)
    }
}