package com.sjy.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bnv : BottomNavigationView
    lateinit var fl : FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnv = findViewById(R.id.bnv)
        fl = findViewById(R.id.fl)

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