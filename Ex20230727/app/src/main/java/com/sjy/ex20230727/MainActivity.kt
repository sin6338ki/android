package com.sjy.ex20230727

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btnStart1 : Button
    lateinit var tvStart1 : TextView
    lateinit var btnStart2 : Button
    lateinit var tvStart2 : TextView
    lateinit var etNum1 : EditText
    lateinit var etNum2 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Thread는 class로 설계한다!
        // class를 실행하려면 객체 생성하고 실행해야 함

        btnStart1 = findViewById(R.id.btnStart1)
        tvStart1 = findViewById(R.id.tvStart1)
        btnStart2 = findViewById(R.id.btnStart2)
        tvStart2 = findViewById(R.id.tvStart2)
        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)

        btnStart1.setOnClickListener {

            var th1 : cntThread = cntThread(tvStart1,etNum1.text.toString().toInt())
            //Thread를 실행하려면 객체를 생성해야 함
            th1.start() //준비, 실행 전에 준비부터 해야함. start 내부에서 자동으로 실행됨
            //위 상태까지만 하면 튕김 -> 안드로이드이기 때문에 한가지 작업을 더 해야 함
            //-> Handler 사용
        }

        btnStart2.setOnClickListener {
            var th1 : cntThread = cntThread(tvStart2, etNum2.text.toString().toInt())
            th1.start()
        }
    }

    var cntHandler : Handler = object: Handler(Looper.getMainLooper()){
        //object : 바로 객체화
        //Handler cntHandler = new Handler(Looper.getManinLooper())
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            //메세지를 받아서 처리하는 곳
            var tv : TextView = msg.obj as TextView
            //as : 형변환
            tv.text = msg.arg1.toString()
//            tvStart1.text = msg.arg1.toString()
        }
    }

    inner class cntThread(var tv : TextView, var num : Int) : Thread(){
        //클래스 안에 클래서 생성시 키워트 : inner
        //Thread 클래스는 Thread()를 상속받음

        //run() 메서드를 오버라이딩
        //1. Thread 클래스 상속 (extends)
        //2. Runnable 인터페이스 구현 (implements)
        //단축키 : alt+insert
        override fun run() {
//            super.run()
            //super.메소드 이름
            //=> 삭제해도 되는 경우 : 매개변수가 없을 때
            //=> 삭제하면 안되는 경우 : 매개변수가 있을 때

            //10~1까지 세기
            for(i in num downTo  1){
                //1. 메세지 생성
                var msg : Message = Message()
                //2. 데이터 세팅 - 3개까지만 가능(arg1 : Int, arg2 : Int, obj : object)
                //=> 데이터가 많을 때 VO를 설계하여 obj에 담아서 보낼 수 있음
                msg.arg1 = i
                msg.obj = tv
                //3. Handler에 전송
                cntHandler.sendMessage(msg)
                Thread.sleep(500)
            }
            //위의 작업이 끝나면 destroyed됨 (계속 실행상태가 아님)
            //즉, Thread는 run메서드가 종료되면 소멸됨
        }
    }
}