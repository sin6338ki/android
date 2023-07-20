package com.sjy.ex20230720

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.w3c.dom.Text

class KakaoViewHolder(var itemView : View) : ViewHolder(itemView) {
                        //생성자                상속
    //class KakaoViewHolder extends ViewHolder{
    //  KakaoViewHolder(View itemView){
    //      super(itemView); super -> 상위 클래스의 생성자 호출
    //   }
    // }

    //템플릿에 있는 view를 저장
    var img : ImageView
    var tv_name : TextView
    var tv_message : TextView
    var tv_time : TextView

    //default 생성자 => 매개변수 X 생성자
    init{
        //itemView => template
        img = itemView.findViewById(R.id.img)
        tv_name = itemView.findViewById(R.id.tv_name)
        tv_message = itemView.findViewById(R.id.tv_message)
        tv_time = itemView.findViewById(R.id.tv_time)
    }
}