package com.sjy.ex20230720

data class KakaoVO(var img : Int? = 0, var name : String? = "", var msg : String? = "", var time : String? ="")
//ChildEvent 클래스에서 DataSnapshot을 KakaoVO로 형변환하고 있음
//=> getValue(KakaoVO::class.java)
//java버젼 => getValue(KakaoVO.class)
//중요! 형변환시 반드시 기본 생성자가 정의되어 있어야 함!
//기본생성자란 ? 매개변수가 하나도 없는 생성자 => KakaoVO(){}
//생성자는 객체를 생성할 때 자동으로 한 번 호출되는 메서드
//Kotlin에서 기본 생성자 만드는 방법! => 매개변수에 null값을 허용해주면 됨

