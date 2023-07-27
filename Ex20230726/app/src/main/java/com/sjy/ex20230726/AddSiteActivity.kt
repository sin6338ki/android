package com.sjy.ex20230726

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.gson.Gson

class AddSiteActivity : AppCompatActivity() {

    lateinit var etTitle : EditText
    lateinit var etAdd : EditText
    lateinit var btnSubmit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_site)

        etTitle = findViewById(R.id.etTitle)
        etAdd = findViewById(R.id.etAdd)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            var intent = Intent()
            val favorite = SiteVO(etTitle.text.toString(), etAdd.text.toString())
            intent.putExtra("favorite", Gson().toJson(favorite))

            //title과 url이 비어있지 않은지 검사하면 더 좋음
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}