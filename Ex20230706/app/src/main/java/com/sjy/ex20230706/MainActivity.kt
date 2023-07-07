package com.sjy.ex20230706

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //필드변수 (=클래스변수 =멤버변수) : 클래스 내 메서드에서는 모두 접근할 수 있음
    //findViewById : 뷰를 찾을 때 setContentView 되어있는 xml 안에서 찾음
    //               -> setContentView 실행 전에 findViewById 진행하면 찾을 수 없음
    //               -> 따라서 클래스 안에서는 변수 선언만 진행
    // lateinit : 초기화는 나중에 진행하겠다
    lateinit var btn1 : Button
    lateinit var btn_change : Button
    lateinit var edt_input : EditText
    lateinit var tv1 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toggle Event 실습
        //onCreate 안에서 변수 선언(지역변수) -> btnClick 함수에서 사용 불가능
//        var btn1 : Button = findViewById(R.id.btn_click)
        btn1 = findViewById(R.id.btn_click)
        btn_change = findViewById(R.id.btn_change)
        edt_input = findViewById(R.id.edt_input)
        tv1 = findViewById(R.id.text_result)

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

//        //EditText 실습
//        btn_change.setOnClickListener {
//            tv1.text = edt_input.text
//
//            //클릭 후 빈칸으로 만드는 방법 3가지
//            edt_input.text = null
//            //edt_input.text.clear()
//            //edt_input.setText("") --> 고전적인 방법
//        } //XML에서 Event 처리하는 코드로 고치기
    }

    // ★XML로 Event 처리하는 방법
    // 1. 버튼을 클릭했을 때 실행될 메소드 정의 (kt)
    //  - 매개변수를 반드시 View타입으로 생성
    // 2. XML 파일을 열어서 버튼 선택 후 onClick 속성에 메소드 연결

    //java version method 생성 : public void btnClick(View currentClick){logic}
    //kotlin version method 생성 : fun btnClick(currentClick : View){Logic}
    fun btnClick(currentClick : View){
        //매개변수에서 변수 생성할 때는 var 생략
        tv1.text = edt_input.text
        edt_input.text = null
    }
}