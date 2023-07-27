package com.sjy.ex20230720

import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError

class ChildEvent(var data : ArrayList<KakaoVO>, var adapter : KakaoAdapter): ChildEventListener{
    //생성자로 데이터 전달 받기

    override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
        //데이터 추가 감지
        //snapshot => firebase에 저장된 데이터
        //json구조로 응답함 => KakaoVO 형태로 변환
        var temp : KakaoVO? = snapshot.getValue(KakaoVO::class.java)
        data.add(temp!!) //!! : not null 단정

    }

    override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
        //데이터 변화 감지
    }

    override fun onChildRemoved(snapshot: DataSnapshot) {
        //데이터 삭제 감지
    }

    override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
        //데이터 이동 감지
    }

    override fun onCancelled(error: DatabaseError) {
        //문제 발생 감지
    }
}