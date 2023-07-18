package com.sjy.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class ColorActivity : AppCompatActivity() {

    lateinit var lv_color:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        lv_color = findViewById(R.id.lv_color)

        var colors = arrayOf("Red", "Green", "Blue")
        var adapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_list_item_1, colors)
        lv_color.adapter = adapter

        //setOnItemClickListener : listView의 항목 클릭 이벤트
        lv_color.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, i, l ->
            //1. 데이터를 담을 빈 Intent 생성
            var it : Intent = Intent() // 왔다가 다시 돌아가는 것이므로 빈 Intent
            //2. Intent에 값 담기(index)
            it.putExtra("color", i)
            //3. 다시 돌려주기 : setResult(코드값, Intent)
            setResult(RESULT_OK, it)
            //4. 종료
            finish()
        })
    }
}