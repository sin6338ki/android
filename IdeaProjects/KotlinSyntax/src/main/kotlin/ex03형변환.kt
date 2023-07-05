fun main() {

    // Int, Float, String? ----> String
    // 안드로이드에서 결과값을 토스트, log를 통해서 확인하고 싶을 때
    // 반드시 문자열로만 출력이 가능하기 때문에 사용함

    val num : Int = 16
    val str = num.toString()
    val str2 = ""+num
    println(str::class.java.simpleName)
    // class.java.simpleName ---> 해당 변수가 가진 자료형을 출력

    // Double(기본), Float
    // Double ---> Float (뒤에 f를 붙이거나 toFloat()를 붙여서 형변환 가능)
    val num2 = 3.141592

    // 스마트 캐스트
    // 서버로부터 나의 전체 성적에 대한 평균을 받아온다.
    // 스마트 캐스트에 적용되는 자료형 : Number --> 숫자형에 대해서만 자동형변환
    var test : Number = 12.2
    println(test::class.java.simpleName)
    test = 56
    println(test::class.java.simpleName)

    // Any (= Object) : 모든 자료형을 포함
    var test2 : Any = "조자연"
    println(test2::class.java.simpleName)  // String
    test2 = 12
    println(test2::class.java.simpleName) // Integer

}