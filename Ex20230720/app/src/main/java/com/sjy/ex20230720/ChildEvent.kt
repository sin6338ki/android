package com.sjy.ex20230720

import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError

class ChildEvent(var data : ArrayList<KakaoVO>, var adapter : KakaoAdapter): ChildEventListener{
    //생성자로 데이터 전달 받기

    override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
        //데이터 추가 감지
    }

    override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
        //데이터 변화 감지
        //ArrayList에 추가된 데이터 추가하고 Adapter 새로고침
        data.add(snapshot.getValue(KakaoVO::class.java) as KakaoVO)
        adapter.notifyDataSetChanged()
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