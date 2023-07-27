package com.sjy.fragment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.sjy.fragment.VO.LoginVO
import org.json.JSONArray

class LoginActivity : AppCompatActivity() {

    lateinit var etLoginId : EditText
    lateinit var etLongPw : EditText
    lateinit var btnLogin : Button
    lateinit var reqQueue : RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etLoginId = findViewById(R.id.etLoginId)
        etLongPw = findViewById(R.id.etLoginPw)
        btnLogin = findViewById(R.id.btnLogin)

        reqQueue = Volley.newRequestQueue(this)

        btnLogin.setOnClickListener{
            val inputId = etLoginId.text.toString()
            val inputPw = etLongPw.text.toString()

            val request = object:StringRequest(
                Request.Method.POST,
                "http://172.30.1.42:8888/login",


                { response ->
                    if (response.toString().equals("login fail")) {
                        Toast.makeText(this, "회원정보가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
                    } else {
                        val member = JSONArray(response).getJSONObject(0)

                        //SharedPreference에 로그인 정보 저장
                        //sharedpreference 생성
                        val spf = getSharedPreferences("mySPF", Context.MODE_PRIVATE)
                        //editor 생성
                        val editor = spf.edit()
                        //editor를 통해서 현재 로그인한 회원의 정보를 저장
                        editor.putString("member", member.toString())
                        //editor 사용 끝 선언
                        editor.commit()

                        //MainActivity로 전환(Intent)
                        var it_login: Intent = Intent(this, MainActivity::class.java)
                        startActivity(it_login)
                    }
                },
                {
                    error ->
                    Log.d("error", error.toString())
                    Toast.makeText(this, "통신 에러", Toast.LENGTH_SHORT).show()
                }
            ){
                override fun getParams(): MutableMap<String, String>{
                    val params:MutableMap<String, String> = HashMap<String, String>()
                    val user = LoginVO(inputId, inputPw, null, null)
                    params.put("user", Gson().toJson(user))
                    return params
                }
            }
            request.setShouldCache(false)
            reqQueue.add(request)
        }
    }
}