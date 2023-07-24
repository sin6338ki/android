package com.sjy.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.util.ArrayList


//ViewHolder : 한개의 아이템 뷰를 구성
//Adapter : ViewHolder 생성 -> 데이터 바인딩
//MainActivity : Adapter 생성, layout 결정
class MainActivity : AppCompatActivity() {

    lateinit var rcPokemon : RecyclerView
    lateinit var reqQueue : RequestQueue
    var pokemonList = ArrayList<PokemonVO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcPokemon = findViewById(R.id.rcPokemon)
        reqQueue = Volley.newRequestQueue(this@MainActivity)

        //1t세대 ->  151
        for(id in 1 until 152){
            val imgUrl = "https:/raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
            val dataUrl = "https://pokeapi.co/api/v2/pokemon-species/$id"

            val request = object : StringRequest(
                Request.Method.GET,
                dataUrl,
                {
                    response ->
                    val result = JSONObject(response)
                    val name = result.getJSONArray("names").getJSONObject(2).getString("name");
                    val pokemon = PokemonVO(id,imgUrl,name)
                    pokemonList.add(pokemon)

                    val adapter:PokemonAdapter = PokemonAdapter(pokemonList, applicationContext) //어댑터 생성
                    rcPokemon.layoutManager = GridLayoutManager(applicationContext, 2)
                    rcPokemon.adapter = adapter

                },{
                    error ->
                    Log.d("error", error.toString())
                    Toast.makeText(this, "error발생", Toast.LENGTH_SHORT).show()
                }
            ){} //object 사용시 body가 꼭 있어야 함 -> {}

            reqQueue.add(request)
        }


    }
}