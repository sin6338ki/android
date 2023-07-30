package com.sjy.ex20230727

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class GameActivity : AppCompatActivity() {

    //배열에 두더지 9마리 저장
    var imgs = arrayOfNulls<ImageView>(9)
    //-> ImageView 타입의 배열 9칸 생성하고 null로 초기화
    var threads = arrayOfNulls<imgThread>(9)
    //-> 쓰레드 객체 9개 저장
    lateinit var tv_score : TextView
    lateinit var tv_time : TextView
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        tv_score = findViewById(R.id.tv_score)
        tv_time = findViewById(R.id.tv_time)

        cntThread(tv_time, 10).start()

        //생성될 때 ImageView를 전달받는 Thread 설계
        //알고리즘 -> run 메서드 오버라이딩

        for(index in 0 until 9){ //0~8까지
            //"imageView1~9" id를 가진 View 주소 알아내는 코드
            var id = resources.getIdentifier("imageView" + (index+1), "id", packageName)
            imgs[index] = findViewById(id) //9개의 ImageView for문 돌면서 찾아옴\
            imgs[index]!!.tag = "off"

            //배열에 생성된 thread 누적
            threads[index] = imgThread(imgs[index]!!)
            threads[index]!!.start()

            //두더지 클릭했을 때 on/off 판단
            //R.drawable.___ 주소로 이미지를 변경했음
            //Android에서 이미지끼리 비교하는 방법은 Drawable이라는 객체로 변경 후 이미지 처리
            //-> 일이 커짐 -> view에 tag라는 변수가 있음! 이를 활용!
            imgs[index]!!.setOnClickListener{
                if(imgs[index]!!.tag.toString() == "on"){
                    score++
                }else{
                    score--
                }
                tv_score.text = score.toString()
            }
        }
    }

    //Handler 구현
    var imgHandler : Handler = object : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            (msg.obj as ImageView).setImageResource(msg.arg1)
            //다운캐스팅 (업캐스팅 되어 있는 상태에서 하위 클래스로 형변환)
            //setImageResource : 주소로 이미지를 넣는것
            //setImageDrawable : 안드로이드에서 사용하는 이미지 객체로 이미지를 넣는 것
            (msg.obj as ImageView).tag = if(msg.arg1 == R.drawable.on)"on" else "off"
        }
    }

    //Thread 클래스 구현
    inner class imgThread(var iv : ImageView) : Thread() {
        override fun run(){

            //Thread 종료시키는 방법
            //1. interrupt를 발생시킨다.
            //2. interrupt를 발생시키면 thread 내부에서는 interrupt exception이 발생한다.
            //3. 이걸 이용해서 try-catch을 활용하여 run 메소드를 종료 => Thread 클래스 안에서 일어남
            try{
                while(true){
                    //두더지마다 랜덤한 offtime 부여
                    var offTime = Random().nextInt(5000) + 500 //0.5~5.5 사이
                    Thread.sleep(offTime.toLong())

                    //올라가는 이미지로 변경
                    var msg = Message()
                    msg.obj = iv //ImageView 타입의 객체가 object 타입으로 형변환
                    msg.arg1 = R.drawable.on
                    imgHandler.sendMessage(msg)

                    //내려가는 이미지로 변경
                    var onTime = Random().nextInt(1000)+500
                    Thread.sleep(onTime.toLong())
                    //Message객체는 일회성! => 한 번 보낸 메세지 객체는 재사용이 불가함
                    msg = Message()
                    msg.obj = iv
                    msg.arg1 = R.drawable.off
                    imgHandler.sendMessage(msg)
                }
            }catch(e : InterruptedException){
                return //메소드 종료
                //메소드는 return 키워드를 만나는 그 즉시 호출한 곳으로 돌아간다.
                //
            }
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

            //Thread 중지
            if(msg.arg1 == 1){
                for(temp in threads){ //for-each문이랑 같음
                    //in 오른쪽에 적힌 배열에서 순서대로 하나씩 꺼내 temp에 저장
                    temp!!.interrupt()
                }
            }
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