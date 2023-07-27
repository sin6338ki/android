package com.sjy.fragment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.sjy.fragment.VO.LoginVO
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var bnv : BottomNavigationView
    lateinit var fl : FrameLayout
    lateinit var btnMoveLogin : Button
    lateinit var tvId : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnv = findViewById(R.id.bnv)
        fl = findViewById(R.id.fl)
        btnMoveLogin = findViewById(R.id.btnMoveLogin)
        tvId = findViewById(R.id.tvId)

        var isLogin : Boolean = false

        val spf = getSharedPreferences("mySPF", Context.MODE_PRIVATE)
        val editor = spf.edit()
        //내가 작성한거
        val loginMember : String? = spf.getString("member", "")
//        val loginId = JSONObject(loginMember).getString("id")

        //GSON으로 데이터 가져오기
        val loginMemberVO = Gson().fromJson(loginMember, LoginVO::class.java)
        val loginId = loginMemberVO.id

        //btnLogout에 클릭리스너
        //-> spf에 저장된 값 삭제
        //-> LoginActivity로 전환 (인텐트)

        //로그아웃
        if(loginId != ""){
            tvId.text = loginId + "님 환영합니다🤍"
            btnMoveLogin.text = "LOGOUT"
            isLogin = true
        }

        btnMoveLogin.setOnClickListener {
            if(isLogin == false){
                var loginIntent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
                isLogin = true
            }else{
                //로그인 기록 삭제
                editor.remove("member")
//                editor.clear() //전체 삭제
                editor.commit()
                var loginIntent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
//                btnMoveLogin.text = "LOGIN"
//                tvId.text = "로그인을 해주세요"
                isLogin = false
            }
        }

        supportFragmentManager.beginTransaction().replace(
            R.id.fl,
            Fragment1()
        ).commit()

        //bnv에서 선택한 메뉴에 따라 fl에 표시할 Fragment 갈아 끼우기
        //setOnItemSelectedListener : item 선택
        bnv.setOnItemSelectedListener {
        //it : 선택한 아이템 가져올 수 있음
            Log.d("id", it.itemId.toString())

            //선택한 아이템의 아이디가 탭의 id와 같을 때 fl(프레임레이아웃)을 Fragment로 교체함
            when(it.itemId){
                R.id.tab1 -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl,
                        Fragment1()
                    ).commit()
                }
                R.id.tab2 -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl,
                        Fragment2()
                    ).commit()
                }
                R.id.tab3 -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl,
                        Fragment3()
                    ).commit()
                }
                R.id.tab4 -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl,
                        Fragment4()
                    ).commit()
                }
            }

            //boolean : true/false => false 이벤트인식을 잘 못함, true => 이벤트 인식의 효율이 더 높음
            true
        }

    }
}