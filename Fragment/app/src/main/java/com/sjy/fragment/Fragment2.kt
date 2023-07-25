package com.sjy.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_2, container, false)

        var btnUrl : Button = view.findViewById(R.id.btnUrl)
        var etUrl : EditText = view.findViewById(R.id.etUrl)
        lateinit var url : String
        //버튼을 클릭하면 사용자가 작성한 url값 가져오기
        btnUrl.setOnClickListener{
            url = etUrl.text.toString()
            //url값 저장하기 (SharedPreference -> 내부 메모리에 저장 -> 모든 fragment에서 사용가능)
            //  - editor 사용
            val spf = requireActivity().getSharedPreferences("mySPF",Context.MODE_PRIVATE)
            //MODE_PRIVATE : 내부 캐시에 저장 -> 저장된 값이 노출되지 않도록
            val editor = spf.edit() //에디터 생성
            editor.putString("url", url) //키-쌍으로 저장
            editor.commit()
        }
        return view
    }

}