package com.sjy.ex20230706

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toggle Event 실습
        var btn1 : Button = findViewById(R.id.btn_click)
        var btn_change : Button = findViewById(R.id.btn_change)

        var edt_input : EditText = findViewById(R.id.edt_input)

        var tv1 : TextView = findViewById(R.id.text_result)

        var isKorean : Boolean = false
        var cnt : Int = 1
        //변수 사용시 자료형 작성하는 것 추천!
        //boolean 1byte 혹은 1bit, int는 4byte -> 메모리 관리를 위해서는 boolean 사용하는 것이 더욱 유리함!

        //xml에서 Hello!라고 정확하게 적어놓지 않으면 click안에 있는 if문은 무쓸모 혹은 이상해짐
        //따라서 이벤트 일어나기 전 한 번 더 정확하게 적어놓고 시작함
        tv1.text = "Hello!"

        btn1.setOnClickListener {
            //방법1. boolean 사용 - true/false 구분
            if(!isKorean){ //isKorean이 false일때 실행 => 비교연산의 결과값이 boolean이므로
                tv1.text = "안녕!"
                tv1.setTextColor(Color.parseColor("#0080FF"))
            }else{
                tv1.text = "Hello!"
                tv1.setTextColor(Color.parseColor("#04B486"))
            }
            isKorean = !isKorean

            //방법2. text속성 사용 - 버튼 눌렀을 때 textview에 뭐라고 적혀있는지 검사
//            if(tv1.text.equals("안녕!")) {
////                Kotlin에서는 String 비교시 ==, equals 모두 사용할 수 있음
//                tv1.text = "Hello!"
//                tv1.setTextColor(Color.parseColor("#04B486"))
//            }else{
//                tv1.text = "안녕!"
//                tv1.setTextColor(Color.parseColor("#0080FF"))
//            }

            //방법3. 홀수/짝수 - 버튼을 누를 때마다 숫자 세어서 홀/짝 구분
            //      숫자를 센다 => cnt에 저장된 값을 1씩 증가
//            if(cnt%2 == 1){
//                tv1.text = "Hello!"
//                tv1.setTextColor(Color.parseColor("#04B486"))
//            }else{
//                tv1.text = "안녕!"
//                tv1.setTextColor(Color.parseColor("#0080FF"))
//            }
//            cnt++ //cnt += 1
        }

        //EditText 실습
        btn_change.setOnClickListener {
            tv1.text = edt_input.text

            //클릭 후 빈칸으로 만드는 방법 3가지
            edt_input.text = null
            //edt_input.text.clear()
            //edt_input.setText("") --> 고전적인 방법
        }
    }
}