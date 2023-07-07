package com.sjy.ex20230707

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btn_plus : Button
    lateinit var btn_minus : Button
    lateinit var tv_num : TextView
    var num : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //XML로 이벤트 처리할 경우 btn은 따로 가져올 필요 없음
        tv_num = findViewById(R.id.tv_num)
        num = tv_num.text.toString().toInt()
    }

    fun onClickPlusBtn(currentClick:View){
        num++
        tv_num.text = num.toString()
    }

    fun onClickMinusBtn(currentClick: View){

        if(num <= 0){
            num = 0
        }else{
            num--
        }
        tv_num.text = num.toString()
    }

    fun btnClick(currentClick: View){
        //버튼이 늘어날때마다 메소드를 추가하는 것은 비효율적
        //click메소드 하나로 여러개의 Event를 처리할 수 있음
        //매개변수 currentClick => 사용자가 클릭한 View

        if(currentClick.id == R.id.btn_plus){
            num++
        }else if(currentClick.id == R.id.btn_minus){
            if(num<=0) num=0 else num--
        }
        tv_num.text = num.toString()
    }

}