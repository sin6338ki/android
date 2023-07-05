fun main() {
    // 실행시킬 코드는 main() 함수 안에 작성

    // 데이터를 저장할 수 있는 공간 만들기
    // 1) val/var
    //  val(value) : 변경이 불가능(immutable)한 변수, 초기화만 가능
    //  var(variable) : 변경이 가능(mutable)한 변수, 초기화/재할당 가능
    // 2) 변수명 : 숫자로 시작 불가능, camel 규칙 선호
    // 3) : 자료형 = 데이터 값

    // 이름을 저장할 수 있는 변수 name을 만들어 보자
    //val name : String = "신지영"
    val name = "신지영"
    // 회색글씨 사용이 된 적 없는 변수이거나 쓰지 않아도 됨
    println(name)
    // 자료형 확인하는 단축키 : Ctrl + Shift + p

    // Kotlin에서는 들어오는 데이터를 보고 자료형 추론이 가능하다
    // >> 변수를 선언할 때 자료형을 생략할 수 있다

    var age = 20
    age = 10

    // 자바 - 선언과 초기화 구문 나눌 수 있음
    // int age;
    // age = 21;

    // 코틀린
    // 코틀린에서 선언과 초기화를 분리하고 싶을 때는
    // 선언단에서 반드시 자료형을 명시해줘야 한다.
    val greet : String
    greet = "안녕하세요"

    println(greet)
}