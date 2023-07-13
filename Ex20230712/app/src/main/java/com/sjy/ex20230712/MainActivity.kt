package com.sjy.ex20230712

import android.app.SearchManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    //iv_kakaopage 이미지뷰 찾기
    lateinit var iv_kakaopage : ImageView
    lateinit var tv_googlekakao : TextView
    lateinit var tv_sms : TextView
    lateinit var tv_call : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //                          Int 주소 반환
        iv_kakaopage = findViewById(R.id.iv_kakaopage)
        tv_googlekakao = findViewById(R.id.tv_googlekakao)
        tv_sms = findViewById(R.id.tv_sms)
        tv_call = findViewById(R.id.tv_call)

        //클릭시 카카오 페이지로 이동 ; ACTION_VIEW
        iv_kakaopage.setOnClickListener{
            //Intent : 화면전환 등에 사용
            //intent 사용하여 카카오 웹페이지로 이동
            //Intent 형태의 객체 생성
            //Intent 매개변수 : 1) 해야할 일 2) 데이터
            var it_kakao : Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kakaocorp.com/page/"))
            //자바라면? Intent it_kakao = new Intent(해야할 일(Action), 데이터(uri))
            //                                       이동       주소

            //2. Intent 실행
            startActivity(it_kakao)
            //중요! startActivities XXXX
        }

        //클릭시 구글에 카카오 검색 : ACTION_WEB_SEARCH
        tv_googlekakao.setOnClickListener{
            //1. Intent 생성
            var it : Intent = Intent(Intent.ACTION_WEB_SEARCH)
            //2. putExtra 함수 사용해서 데이터 담아주기
            it.putExtra(SearchManager.QUERY, "설빙")
            //3. Intent 실행
            startActivity(it)
        }

        //클릭시 문자 보내기 : ACTION_SENDTO
        tv_sms.setOnClickListener{
            //문자 보내는 페이지까지 이동
            //실제로 문자 보내야할 때!!
            //통신 규정상 문자를 직접 보낼 수 없음 -> 문자 보내주는 업체에서 제공하는 API 활용하여 사용

            //1.Intent 생성
            var it : Intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:010-2776-6338"))

            //2. putExtra 함수 사용 문자 내용 작성
            it.putExtra("sms_body", "하이!")

            //3. Intent 실행
            startActivity(it)
        }

        //클릭시 전화 걸기 : ACTION_CALL
        tv_call.setOnClickListener{
            //intent 생성=> 실행 : 여기까지만 작성하면 튕긴다!
            //왜냐하면 Android에는 예민한 기능이 있다.
            //전화, GPS, 갤러리 -> 사용을 위해서는 권한요청이 필요!
            //권한요청을 해서 사용자가 허용을 해야 기능을 수행될 수 있도록 Android가 설계해놨음
            
            //1. 이미 권한을 승인하지 않았는지 검사
            //2. 승인하지 않았다면 다이얼로그(팝업창)를 띄어서 허용을 받음
            //                                      현재화면정보
            //3. Manifest.xml 파일 열어서 permission 태그 추가
            if(ActivityCompat.
                checkSelfPermission(applicationContext, android.Manifest.permission.CALL_PHONE) 
                != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, 
                arrayOf(android.Manifest.permission.CALL_PHONE), 0
                )
                //GPS 등 권한 요청하고 싶을 때 : CALL_PHONE 대신 요청받고 싶은 내용 작성
            }

            //1. Intent 생성 (Action, Data)
            var it : Intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:010-2776-6338"))
            //2. Intent 실행
            startActivity(it)

            
        }

    }
}