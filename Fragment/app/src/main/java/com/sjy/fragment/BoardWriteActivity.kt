package com.sjy.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class BoardWriteActivity : AppCompatActivity() {

    lateinit var btnPrev : ImageButton
    lateinit var etTitle : TextView
    lateinit var etContents : TextView
    lateinit var img : ImageView
    lateinit var btnCamera : ImageButton
    lateinit var btnGallery : ImageButton
    lateinit var btnWriting : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_write)

        btnPrev = findViewById(R.id.btnPrev)
        etTitle = findViewById(R.id.etTitle)
        etContents = findViewById(R.id.etContents)
        img = findViewById(R.id.img)
        btnCamera = findViewById(R.id.btnCamera)
        btnGallery = findViewById(R.id.btnGallery)
        btnWriting = findViewById(R.id.btnWriting)

    }
}