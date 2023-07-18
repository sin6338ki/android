package com.sjy.ex20230718

//data : 일반클래스가 아닌 데이터 클래스를 만들 수 있음
//data class : POJO(Plain Old Java Object)
//              - 클래스 내에 필드, 생성자, 게터, 세터만 가지고 있는 아주 가벼운 형태의 자바
//  -> 필드만 작성 -> getter, setter ... 자동 생성
// 조건
// 1) 최소 하나의 파라미터(필드)가 있어야 함
// 2) 파라미터는 val or var로 선언
// 3) abstract, open(코틀린에서 부모 클래스 지정시 붙여주는 키워드),
//      sealed(자식클래스를 제한하는 키워드),
//      inner(클래스 안에 클래스(중첩 클래스) 지정 키워드) 사용 불가
// 4) 다른 클래스를 상속 받을 수 없음 (sealed 클래스는 상속 받을 수 있음)
data class WeatherVO(var city:String, var state:String, var temp:Int)