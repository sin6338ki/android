package com.sjy.firstapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    lateinit var btn_bgcolor:Button
    lateinit var main : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_bgcolor = findViewById(R.id.btn_bgcolor)
        main = findViewById(R.id.bg)

        btn_bgcolor.setOnClickListener {
            //startActivity => 편도
            //ForResultLuancher => 왕복
            var it : Intent = Intent(this, ColorActivity::class.java)
            //startActivity(it)
            frLauncher.launch(it)
        }
    }

    //Launcher 설계
    //                  resultLauncher 만들어주는 메서드
    var frLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        //it : activity 이동했다 돌아올 때 담아준 데이터를 가지고 있음
        //갔다가 돌아왔을 때 실행되는 부분
        //1. 이상 없이 잘 돌아왔는지 검사 진행
        if(it.resultCode == RESULT_OK){
            //2. 담아준 데이터가 있는지 검사
            //  getIntExtra(key, defaultValue)
            // defaultValue => 키값이 없을 때
            val color = it.data!!.getIntExtra("color", -1) //!! : not null일때만 실행

            if(color == 0){
                main.setBackgroundColor(Color.RED)
            }else if(color == 1){
                main.setBackgroundColor(Color.GREEN)
            }else{
                main.setBackgroundColor(Color.BLUE)
            }
        }
    }
}