package com.sjy.ex20230726

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var rv : RecyclerView
    lateinit var btnAdd : Button
    var data = ArrayList<SiteVO>()
    lateinit var adapter : SiteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data.add(SiteVO("네이버", "http://www.naver.com"))
        data.add(SiteVO("유튜브", "http://www.youtube.com"))
        data.add(SiteVO("구글", "http://www.google.com"))
        data.add(SiteVO("SMHRD", "http://www.smhrd.or.kr"))

        rv = findViewById(R.id.rv)
        btnAdd = findViewById(R.id.btnAdd)

        adapter = SiteAdapter(applicationContext, R.layout.item_view, data)
        rv.layoutManager = LinearLayoutManager(applicationContext)
        rv.adapter = adapter

        //클릭했을 때 database에 정보 추가
        btnAdd.setOnClickListener {
            var intent : Intent = Intent(this, AddSiteActivity::class.java)
            frLauncher.launch(intent)
        }
    }

    var frLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            val favorite = it.data!!.getStringExtra("favorite")
            Log.d("favorite", favorite.toString())
            val favoriteVO = Gson().fromJson(favorite, SiteVO::class.java)
            data.add(favoriteVO)
            adapter.notifyDataSetChanged()
        }
    }
}