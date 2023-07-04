package com.example.ex20230703
//calculatorActivity의 위치 : 꼭 명시되어야 함

//import
//supportv4가 import 되는 경우가 있음 > androidx가 import되어 있어야 함
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

// :(콜론) - 상속(inheritance)을 의미함
// Calculator는 appCompat 을 상속받음
// onCreate : main()와 유사한 기능을 하는 함수,
//              Emulator를 실행시켰을 때 처음에 딱 한번 컴파일 되어지는 함수
// Bundle : 가로, 세로모드에서 텍스트를 유지
class CalculatorActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView : 어떤 화면에 기능을 달아줄건지 명시
        //R : res (resource)
        //View를 세팅하기 이전에 findViewById를 하는건 불가능
        //NPE가 발생한다!
        setContentView(R.layout.activity_calculator4)

        //기능을 달아주기 위해서는 각 view들을 구분할 수 있어야 함 > 속성 id로 구분
        //id 작성 규칙
        //EditText ---> 숫자를 입력하는 기능 num1 >> etNum1
        //Button ---> 더하기 기능 >> btnPlus
        //java - snake, kotlin - camel

        //btnPlus를 클릭했을 때 이벤트가 일어나는지 확인
        //id는 16진수 변환되어 R/id클래스에 보관되어 있음 (보안상 보이지 않음)
        //R.id에 접근하여 16진수의 값을 찾아와야 함 > findViewById()
        //xml에 부여했던 id값을 class에서 바로 참조하는 건 불가능
        //xml에 부여한 id --> R.id에 저장이 된다. (16진수의 랜덤한 값)
        //--> Class에서 findViewById()
        //Id값(16진수의 랜덤한 값)을 통해서 View를 찾아온다!
        val btnPlus : Button = findViewById(R.id.btnPlus)
        //코틀린은 자료형 추론이 가능하므로 <Button> 생략 가능
        //full code : val btnPlus : Button = findViewById<Button>(R.id.btnPlus)

        //TypeMismatchException : 내가 찾아오려는 View랑 변수의 view타입이
        //                        일치하지 않을 경우 발생하는 예외 상황

        //디버깅 방법 : 로그, 토스트창
        //1. Toast창을 Emulator에 띄워보자 (문구:클릭!!)
        //2. log를 통해 확인해보자

        //onClickListener
        btnPlus.setOnClickListener {
            //it:View! View의 정보를 받아오는 매개변수
            //btnPlus를 클릭했을 때 실행시킬 코드
            Toast.makeText(this@CalculatorActivity4,"클릭!!",Toast.LENGTH_SHORT).show()
            //문구들이 숫자자료형을 가질 수 없음(resId만 숫자 가질수 있음)
            //CharSequence : String의 부모형
            //1) context : 화면정보(어디에 토스트를 보여지게 만들것인가)
            //this@CalculatorActivity
            //2) text : CharSequence! --> String의 문구
            // - Int자료형을 띄울 수는 있음. 단, View의 id값만 가능
            //3) duration : toast 창의 지속 시간(몇초동안 띄울것인가)
            //toast.length_short - 3초 정도, log - 5초 정도
            //+show() : Toast 창이 화면에 보임
        }

    }
}