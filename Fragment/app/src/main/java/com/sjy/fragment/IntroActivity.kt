package com.sjy.fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val handler = Handler()
        //postDelayed(뭘할건지(action), 딜레이시간(ms))
        handler.postDelayed({
            //Intro 화면이 보이고 3초 뒤에 MainActivity로 전환 (Intent 사용)
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}