package com.sjy.ex20230705

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //준비
        setContentView(R.layout.activity_main) //xml + kt 연결

        //1. Button 찾기
        var btn1 : Button= findViewById(R.id.button)
        var btn2 : Button = findViewById(R.id.button2)

        //2. TextView 찾기
        var tv1 : TextView = findViewById(R.id.textView)

        //3. Button 눌렀을 때를 감지할 Event Listener 달아주기
        btn1.setOnClickListener {
            //4. Listener 안에서 TextView의 text 속성 바꾸기
            //tv1.setText("Good Bye!") --> 메서드 호출 (자바 스타일)
            tv1.text = "Good Bye!" //Kotlin에서 사용 추천하는 문법!
            //text라는 속성을 변수로 보는 기법 > public 변수에 접근
            tv1.setTextColor(Color.parseColor("#CC2EFA")) //메서드 접근
            //c: 클래스, f : 상수, m: 메서드
        }

        btn2.setOnClickListener {
            tv1.text = "Hello!"
            tv1.setTextColor(Color.parseColor("#FF0000"))
        }
    }
}