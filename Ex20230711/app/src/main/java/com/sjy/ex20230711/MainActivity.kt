package com.sjy.ex20230711

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    //1. Button 25개 findViewById => 배열, for문
    // - 변수로 생성하면 노가다, 순서가 없어서 for문도 못돌림...
    //2. 1~25까지 저장된 배열 생성! 랜덤으로 섞기
    //3. Button에 숫자 띄우기
    //4. ClickEvent 처리하기
    // - 버튼을 클릭하면 사라지기!
    // - 순서에 맞는지 확인하기!
    // - 25 버튼 클릭하면 카운트 멈추기

    //Kotlin 배열 : Arrayof
    //ex. var temp = arrayOf(1,2,3) --> 초기값 있을 때
    //ex. var btns = arrayOfNulls<Button>(25) ---> 초기값 없을 때

    var btns = arrayOfNulls<Button>(25)
    var nums = Array(25){i -> i+1} //람다식으로 1~25까지 채운 배열 생성
    var cnt : Int = 1
    lateinit var time : Chronometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        setContentView(R.layout.login) //로그인xml 띄우는 방법!
            setContentView(R.layout.gamelayout)

            //타이머 시작
            time = findViewById(R.id.tv_time)
            time.start()

//        //for문
//        for(x in 0 .. 24){}
//        for(x in 0 until 25){}
//
//        //배열이랑 함께 쓰는 for문
//        for((x, data) in btns.withIndex()){
//            // x : index
//            // data : value
//        }

        //숫자 랜덤으로 섞기
        nums.shuffle() //배열 랜덤으로 섞기


        for(index in 0 until 25){
            //id명(String)으로 주소값(int) 알아내기
            var id : Int = resources.getIdentifier("btn" + (index + 1), "id", packageName)
            btns[index] = findViewById(id)

            //버튼에 숫자 띄우기
            btns[index]!!.text = nums[index].toString()

            //순서에 맞는지 확인
            //버튼 누를때마다 count 세기
            //count와 btn의 text가 같으면 사라지게 만들기
            //!! => null값이 아닐때만 메소드 호출
            btns[index]!!.setOnClickListener {
                //버튼 클릭시 사라지게 만들기
                if(cnt.toString() == btns[index]!!.text){
                    btns[index]!!.visibility = View.INVISIBLE //view를 화면에서 안보이게 만드는 코드
                    cnt++
                }
                if(cnt==25){
                    time.stop()
                }
            }
        }
    }
}