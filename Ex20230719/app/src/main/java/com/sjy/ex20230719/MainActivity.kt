package com.sjy.ex20230719

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    lateinit var  lv_list : ListView
    lateinit var btn_write : Button
    lateinit var btn_login : Button
    lateinit var tv_loginCk : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lv_list = findViewById(R.id.lv_list)
        btn_login = findViewById(R.id.btn_login)
        btn_write = findViewById(R.id.btn_write)
        tv_loginCk = findViewById(R.id.tv_loginCk)

        // listView 만들 때!
        // 1. 데이터 (배열 / ArrayList)
        // 2. 템플릿 (.xml)
        // 3. 어댑터 (.kt : BaseAdapter 상속)
        var lists = arrayOf("1. Android 짱 재밌음", "2. 아님 어려움...", "3. 그래도 재밌음!!!", "4. 이디오 겁나 귀여움")
        var adapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_list_item_1, lists)
        lv_list.adapter = adapter

        btn_login.setOnClickListener {

            //로그인 버튼 클릭시 로그인 페이지 이동
            var it_login : Intent = Intent(this, LoginActivity::class.java)
            frLauncher.launch(it_login)

        }
    }

    var frLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            val id = it.data!!.getStringExtra("id")

            tv_loginCk.text = id + "님 환영합니다!"
            btn_write.isVisible = true
            btn_login.text = "로그아웃"
        }
    }

}