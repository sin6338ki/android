package com.sjy.ex20230720

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //listView 의 업그레이드 버전
    //RecyclerView 만들기 : 똑같은 템플릿 반복, 스크롤 기능
    //Custom RecyclerView
    //★ 원리!
    //Data의 개수만큼 Template을 복사하여 RecyclerView 안에 배치
    //=> adapter

    //1. Data (VO, ArrayList)
    //2. Template : 눈에 보이는 형태 그대로 (.xml)
    //3. Adapter (.kt)
    // - viewHoler (.kt)도 만들어야 함

    lateinit var rv : RecyclerView
    lateinit var edt : EditText
    lateinit var btn_send : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var data = ArrayList<KakaoVO>()
        //add 함수 사용하여 메시지 5개 저장
        //1개의 메세지를 저장하기 위해 새로운 자료형을 설계

        rv = findViewById(R.id.listview)
        edt = findViewById(R.id.edt_message)
        btn_send = findViewById(R.id.btn_send)

//        data.add(KakaoVO(R.drawable.img1, "지영", "밥먹쟈", "오전 9:20"))
        data.add(KakaoVO(R.drawable.img2, "지희", "뭐먹을랭", "오전 10:30"))
        data.add(KakaoVO(R.drawable.img3, "현록", "타마곡ㄱㄱ", "오전 10:40"))
        data.add(KakaoVO(R.drawable.img4, "지훈", "ㅇㅋㅇㅋ", "오전 11:30"))
        data.add(KakaoVO(R.drawable.img5, "혁", "굿", "오후 12:30"))


        var adapter : KakaoAdapter = KakaoAdapter(applicationContext, R.layout.template, data)

        //★★★★★ layoutManager 세팅
        rv.layoutManager = LinearLayoutManager(applicationContext) //목록형
        rv.adapter = adapter

        btn_send.setOnClickListener{
            data.add(KakaoVO(R.drawable.img1, "나", edt.text.toString(), "오전 13:00"))
            //adapter 새로고침
            adapter.notifyDataSetChanged()
            edt.text.clear()
            //스크롤을 원하는 위치로 이동시키기
            rv.smoothScrollToPosition(data.size-1)
        }

    }
}