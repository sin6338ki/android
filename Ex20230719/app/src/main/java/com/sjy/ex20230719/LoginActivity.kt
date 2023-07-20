package com.sjy.ex20230719

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var edt_id : EditText
    lateinit var edt_pw : EditText
    lateinit var btn_login : Button

    lateinit var members : HashMap<String, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        members = HashMap()
        members.put("wldud", "0616")
        members.put("jiyoung", "6338")
        members.put("smhrd", "12345")
        members.put("K", "11111")
        members.put("sjy", "93")

        edt_id = findViewById(R.id.edt_id)
        edt_pw = findViewById(R.id.edt_pw)
        btn_login = findViewById(R.id.btn_login_login)

        btn_login.setOnClickListener {
            val id = edt_id.text.toString()
            val pw = edt_pw.text.toString()

            if(members.containsKey(id)){
                if(members.get(id).equals(pw)){
                    var it : Intent = Intent()
                    it.putExtra("id", id)
                    setResult(RESULT_OK, it)
                    finish()
                }else{
                    Toast.makeText(applicationContext, "패스워드가 틀립니다", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(applicationContext, "존재하지 않는 아이디입니다", Toast.LENGTH_SHORT).show()
            }
        }

    }
}