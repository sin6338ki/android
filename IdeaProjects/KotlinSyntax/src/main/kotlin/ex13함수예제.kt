fun main() {

    var num1 = 24
    var num2 = 13
    var result = largerNumber(num1, num2)

    println(result)
}

fun largerNumber(num1:Int, num2:Int) : Int {
    var result2 = if(num1 > num2) num1 else if(num1 < num2) num2 else 0
    return result2
}

// 함수를 main 안쪽에서 만들고 싶을 경우에는
// 함수를 호출하는 코드 위쪽에 작성해야 함
// 위에서 아래서 코드는 컴파일 되기 때문
// ---->  이러한 함수는 지역함수
// main은 최상위 함수
// main 바깥쪽에서 함수를 선언하면 최상위 함수가 됨
