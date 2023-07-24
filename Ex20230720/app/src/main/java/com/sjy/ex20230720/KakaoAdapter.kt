package com.sjy.ex20230720

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter

class KakaoAdapter(var context:Context, var template:Int, var data:ArrayList<KakaoVO>)
    : Adapter<KakaoViewHolder>() {
    //상위 클래스인 Adapter 클래스는 추상 클래스
    // => 추상 클래스를 상속받는 하위 클래스는 반드시 추상 메서드를 오버라이딩(재정의)해야한다.
    // => 오버라이딩 안하려면 추상화
    //adapter : templete과 data 연결 (매개변수 3개 : 화면, 템플릿, 데이터)
    //
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KakaoViewHolder {
        //templete에 있는 view를 저장하는 viewholoder를 생성
        //하나의 리싸이클러뷰에서 최초 1번만 실행 >> onBindViewHolder에서 꾸밈
        //xml => kt(java) 객체로 만드는 작업을 Inflater라고 부름
        //대표적으로 findViewById

        //ViewHolder를 생성할 때 Templete.xml을 View타입으로 변환해서 전달
        var templete_view : View = LayoutInflater.from(context).inflate(template, parent, false)
        var VH : KakaoViewHolder = KakaoViewHolder(templete_view)

        return VH
    }

    override fun getItemCount(): Int {
        //전체 아이템의 개수를 리턴하는 곳
        //return 5 => 5개 반환
        return data.size
    }

    override fun onBindViewHolder(holder: KakaoViewHolder, position: Int) {
        //제네릭기법 : 클래스를 설계하는 시점에는 자료형을 기재하지 않는다.
        //이전에 쓰던 ViewHolder에서 View를 꺼내다가 ArrayList에 저장된 데이터들로 꾸밈!
        //getItemCount에 적힌 숫자만큼 호출됨

        var img : ImageView = holder.img
        var tv_msg : TextView = holder.tv_message

        var KakaoMessage : KakaoVO = data.get(position)

        img.setImageResource(KakaoMessage.img)
        tv_msg.text = KakaoMessage.msg

        //ver2.
        holder.tv_name.text = data.get(position).name
        holder.tv_time.text = data.get(position).time
    }

}
