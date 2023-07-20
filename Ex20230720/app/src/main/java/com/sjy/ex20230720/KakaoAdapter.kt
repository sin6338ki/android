package com.sjy.ex20230720

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.Adapter

class KakaoAdapter(var context:Context, var template:Int, var data:ArrayList<KakaoVO>)
    : Adapter<KakaoViewHolder>() {
    //상위 클래스인 Adapter 클래스는 추상 클래스
    // => 추상 클래스를 상속받는 하위 클래스는 반드시 추상 메서드를 오버라이딩(재정의)해야한다.
    // => 오버라이딩 안하려면 추상화
    // => 추상메서드 :

}