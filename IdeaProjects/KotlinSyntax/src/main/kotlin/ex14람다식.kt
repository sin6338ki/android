fun main() {
    //이름이 없는 함수를 람다식으로 선언한 형태
    {x:Int, y:Int -> x+y}
    //더하기 기능을 필요할때마다 사용하려면 어딘가에 저장
    // : 변수
    // 작성 방법
    // 변수 선언 : (매개변수의 자료형) -> 리턴값의 자료형 = 이름 없는 함수
    val sum : (Int, Int) -> Int = {x:Int, y:Int -> x+y}
    val sum1 : (Int, Int) -> Int = {x, y -> x+y}
    // 람다식 간략화 하기
    // 1. 람다식의 매개변수에 자료형이 지정되어 있다면
    //    변수에 자료형은 생략할 수 있다.
    val sum2 = {x:Int, y:Int -> x+y}
    // 2. 변수에 매개변수의 자료형이 지정되어 있다면
    //    람다식의 매개변수 자료형이 생략될 수 있다.
    // 단, 1번과 2번을 동시에 사용할 수 없다.
    // 왜냐하면 자료형 추론이 불가능한 상태가 되어버리기 때문

    // "Hello Kotlin"을 출력하는 기능을 가진 람다식 함수 선언
    // greet라는 변수에 함수 담아주기! (간략화X)

    // 정사각형의 넓이를 구하는 람다식 함수 선언
    // square라는 변수에 함수를 담아주기
    // 매개변수 : 한 변의 길이

    fun greet():Unit{
        print("Hello Kotlin")
    }

    val greet : () -> Unit = { println("Hello Kotlin") }
//    val greet = {println("Hello Kotlin")}

    fun square(x:Int):Int{
        return x*x
    }

//    val square : (Int) -> Int = {x:Int -> x*x}
    val square = {x:Int -> x*x}

    // 람다식
    // 장점 : 코드를 간략화, 함수를 변수처럼 사용 가능
    // 단점 : 함수에 사용되는 매개변수를 다 알고 있어야 함

}