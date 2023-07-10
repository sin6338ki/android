package com.sjy.ex230707_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var image_me : ImageView
    var img_array = arrayOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)
    var index : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image_me = findViewById(R.id.img_me)

        //1. btnClick 메소드 만들기
        //2. ImageView 찾기
        // - 이전에는 TextView의 text 속성을 바꿨음. 이번에는 ImageView의 ImageResource 를 바꿔줌
        //3. 클릭이 일어난 버튼의 id값에 따라 ImageView의 ImageResource를 바꿔주면 됨
        // - 이미지뷰.setImageResource(R.drawable.이미지파일명)
        //1, 2, 3 버튼 이벤트 구현하기!

        //배열 사용
        //배열을 쓰는 이유 : 1) 같은 자료형의 변수를 한번에 생성할 수 있음
        //                  2) 순서가 없는 데이터에 순서(index)를 부여해줄 수 있음
    }

    fun btnClick(currentClick: View){

        //버튼1,2,3 클릭했을 때
        if(currentClick.id == R.id.btn1){
            index = 0
        }else if(currentClick.id == R.id.btn2){
            index = 1
        }else if(currentClick.id == R.id.btn3){
            index = 2
        }
        //이전버튼
        else if(currentClick.id == R.id.btn_pre){
            if(index==0){
//                index=2
                Toast.makeText(applicationContext, "첫번째 사진입니다.", Toast.LENGTH_SHORT).show()
            }else{
                index--
            }
        }
        //다음버튼
        else if(currentClick.id == R.id.btn_next){
            if(index == img_array.size-1){
//                index=0
                Toast.makeText(applicationContext, "마지막 사진입니다.", Toast.LENGTH_SHORT).show()
            }else{
                index++
            }
        }
        //이미지 클릭
        else if(currentClick.id == R.id.img_me){
            var randNum = Random.nextInt(2)
            index = randNum
        }
        image_me.setImageResource(img_array[index])
    }
}