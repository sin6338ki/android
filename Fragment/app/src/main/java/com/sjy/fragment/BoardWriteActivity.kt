package com.sjy.fragment

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.sjy.fragment.VO.BoardVO
import com.sjy.fragment.VO.LoginVO
import java.io.ByteArrayOutputStream

class BoardWriteActivity : AppCompatActivity() {

    lateinit var btnPrev : ImageButton
    lateinit var etTitle : TextView
    lateinit var etContents : TextView
    lateinit var img : ImageView
    lateinit var btnCamera : ImageButton
    lateinit var btnGallery : ImageButton
    lateinit var btnWriting : Button

    lateinit var reqQueue : RequestQueue

    lateinit var encodignImgString : String
    val STORAGE_CODE = 1000

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

        reqQueue = Volley.newRequestQueue(this)

        //로그인 정보 가져오기 (LoginActivity에서 저장한 spf)
        val spf = getSharedPreferences("mySPF", Context.MODE_PRIVATE)
        val loginUser = Gson().fromJson(spf.getString("member", ""), LoginVO::class.java)

        //갤러리 불러오기
        btnGallery.setOnClickListener{
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            //intent 타입 지정
            intent.type = "image/*"
            //갤러리에 접근하는 것도 또 다른 Act
            //갤러리로 이동 -> 선택한 이미지를 다시 가져와야함
            //다른 액티비티가 시작이 된 후 그 액티비티의 결과를 다시 가져오고 싶을 때 사용!
            startActivityForResult(intent, STORAGE_CODE) //manifest에서 permission추가해야 함
        }


        //작성한 게시물 서버로 전송하기
        btnWriting.setOnClickListener {

            val inputTitle =  etTitle.text.toString()
            val inputContent = etContents.text.toString()
            val writer = loginUser.id

            val request = object:StringRequest(
                Request.Method.POST,
                "http://172.30.1.42:8888/board/write",
                {
                    response ->
                    Log.d("response", response.toString())
                    if(response.toString().equals("Success")){
                     val intent = Intent(this, MainActivity::class.java)
                     startActivity(intent)
                    }
                },
                {
                    error ->
                    Log.d("error", error.toString())
                }
            ){
                override fun getParams() : MutableMap<String, String>{
                    val params:MutableMap<String, String> = HashMap<String, String>()
                    val board = BoardVO(null, inputTitle, inputContent, writer, encodignImgString, null)
                    params.put("board", Gson().toJson(board))
                    return params
                }
            }
            request.setShouldCache(false)
            reqQueue.add(request)
        }
    }
    //
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //CODE에 따라서 어떤 로직을 처리할 것인가
        when(requestCode){
            STORAGE_CODE -> {
                //사용자가 선택한 image uri 가져오기
                val selectedImgUri = data?.data
                if(selectedImgUri!=null){
                    //uri를 bit맵 형태로 변환(필수)
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedImgUri)

                    //이미지 뷰에 bitmap으로 변환한 사진 띄우기
                    img.setImageBitmap(bitmap)

                    //크기 리사이징 1)
                    val options = BitmapFactory.Options()
                    options.inSampleSize = 4 //4개의 픽셀을 1개의 픽셀로 만들어준다. (1/4크기로 변환)
                    //크기 리사이징 2)
                    //filter : true => 선명한 이미지
                    val resized = Bitmap.createScaledBitmap(bitmap, 100, 100, true)

                    //인코딩 (비트맵 -> 스트링)
                    encodeBitmapImg(resized)
                }
            }
        }
    }

    //비트맵 사진 이미지를 문자열로 변환하는 함수 : bitmap -> String (Base64)
    private fun encodeBitmapImg(bitmap:Bitmap){
        //이미지들을 문자로 변환한 것의 배열 형태를 만듦 : byte값이 들어가는 array
        val byteArrOutputStream = ByteArrayOutputStream()

        //받아온 bitmap을 압축 : compress(format, 압축률, outputstream)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrOutputStream)

        //byte의 형태의 데이터가 들어가는 array생성 (이미지 -> array)
        val byteOfImg = byteArrOutputStream.toByteArray()

        //encoding : ByteArray -> String(Base64)
        encodignImgString = Base64.encodeToString(byteOfImg, Base64.DEFAULT)
    }
}