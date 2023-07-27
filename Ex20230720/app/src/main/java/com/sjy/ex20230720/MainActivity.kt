package com.sjy.ex20230720

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

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

    //FireBase => 구글 클라우드 서버
    //클라우드(dropbox, 네이버클라우드) 서버
    //구글에서 일정량의 저장소와 서버를 구축해두고 Android 개발자에게 제공하는 서비스
    //목적 : Android 개발자가 서버를 구현하는 번거로움을 해소



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var data = ArrayList<KakaoVO>()
        //add 함수 사용하여 메시지 5개 저장
        //1개의 메세지를 저장하기 위해 새로운 자료형을 설계

        rv = findViewById(R.id.listview)
        edt = findViewById(R.id.edt_message)
        btn_send = findViewById(R.id.btn_send)

        // Write a message to the database
        //App에 연결되어 있는 FireBase DataBase 객체 가져오기
        val database = Firebase.database
        //DataBase 경로 가져오기
        val myRef = database.getReference("message")
        //해당 경로에 데이터 저장하기

//        data.add(KakaoVO(R.drawable.img1, "지영", "밥먹쟈", "오전 9:20"))
//        myRef.push().setValue(KakaoVO(R.drawable.img2, "지희", "뭐먹을랭", "오전 10:30"))
//        myRef.push().setValue(KakaoVO(R.drawable.img3, "현록", "타마곡ㄱㄱ", "오전 10:40"))
//        myRef.push().setValue(KakaoVO(R.drawable.img4, "지훈", "ㅇㅋㅇㅋ", "오전 11:30"))
//        myRef.push().setValue(KakaoVO(R.drawable.img5, "혁", "굿", "오후 12:30"))

        var adapter : KakaoAdapter = KakaoAdapter(applicationContext, R.layout.template, data)

        //★★★★★ layoutManager 세팅
        rv.layoutManager = LinearLayoutManager(applicationContext) //목록형
        rv.adapter = adapter

        btn_send.setOnClickListener{
            myRef.push().setValue(KakaoVO(R.drawable.img2, "지희", "뭐먹을랭", "오전 10:30"))
            myRef.push().setValue(KakaoVO(R.drawable.img3, "현록", "타마곡ㄱㄱ", "오전 10:40"))
            myRef.push().setValue(KakaoVO(R.drawable.img4, "지훈", "ㅇㅋㅇㅋ", "오전 11:30"))
            myRef.push().setValue(KakaoVO(R.drawable.img5, "혁", "굿", "오후 12:30"))
            data.add(KakaoVO(R.drawable.img1, "나", edt.text.toString(), "오전 13:00"))
            //adapter 새로고침
            adapter.notifyDataSetChanged()
            edt.text.clear()
            //스크롤을 원하는 위치로 이동시키기
            rv.smoothScrollToPosition(data.size-1)
        }

        myRef.addChildEventListener(ChildEvent(data, adapter))

    }
}