package com.sjy.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient

class Fragment1 : Fragment() {

    //View생성(**)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //inflate : xml -> view 객체로 만들어줌
        //onCreateView : fragment와 짝궁인 xml을 리턴해주는 역할
        //cf. activity에서 setContentView와 비슷한 역할 (setContentView : kt, xml 연결)
        var view = inflater.inflate(R.layout.fragment_1, container, false)

        //WebView component 가져오기
        var wv : WebView = view.findViewById(R.id.wv)

        //SharedPreference 가져오기
        val spf = requireActivity().getSharedPreferences(
            "mySPF",
            Context.MODE_PRIVATE
        )
        //SharedPreference 안에 저장된 값 꺼내서 사용하기
        //getString(키값, 기본값)
        var url : String? = spf.getString("url", "http://www.google.com")

        //보여주고 싶은 web url 지정
//        val url : String = "https://www.google.com"

        //web setting
        //1. javascript 사용 가능하도록 허용
        val ws = wv.settings
        ws.javaScriptEnabled = true

        //2. WebView에 클라이언트 설정
        wv.webViewClient = WebViewClient()

        //3. WebView에 url 적용
        //url? -> null값 허용
        //url!! -> null값 허용X
        wv.loadUrl(url!!)

        return view
    }

}