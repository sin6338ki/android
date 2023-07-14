package com.sjy.ex20230712

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class SubActivity : AppCompatActivity() {

    lateinit var btn_moveMain : Button
    lateinit var listview : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        btn_moveMain = findViewById(R.id.btn_moveMain)
        listview = findViewById(R.id.listview)

        btn_moveMain.setOnClickListener {
//            var it_moveMain : Intent = Intent(this, MainActivity::class.java)
//            startActivity(it_moveMain) //새로운 Activity를 Task에 쌓는 명령
                finish() //Activity 삭제
        }

        //listview 만들기
        //1. 데이터 (띄우고자 하는 데이터)
        //2. 템플릿 (한 줄에 어떤 모양으로 표시할 것인지) - 템플릿 디자인 : Custom list view
        //    => android에서 제공하는 템플릿 사용
        //3. Adapter (Data + 템플릿)
        //    => android에서 제공하는 adaptor 사용

        //1. 데이터
        var foods = arrayOf("햄버거", "피자", "치킨", "뼈해장국", "닭발")
        //2. 어댑터 생성
                                            //                  android 제공 기본 템플릿             데이터
        var adapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_list_item_1, foods )

        //3. listview에 adaptor 연결
        listview.adapter = adapter

    }
}