import java.util.Random
import java.util.Scanner

fun main() {
    // Scanner sc = new Scanner(System.in);
    // 자료형  레퍼런스변수명  =  생성자;

    // val/var 변수명 : 자료형 = 데이터 값
    val sc : Scanner = Scanner(System.`in`)

    // 내부적으로 설계되어 있는 입력 기능
//    var input = readLine() // String?
    // Int로 바꿔서 정답인지 아닌지 판단해야 할 수도 있음

    // 지영 풀이
    // 랜덤한 수 생성
    val num1 : Int = Random().nextInt(10)+1
    val num2 : Int = Random().nextInt(10)+1
    print(num1)
    print("+")
    print(num2)
    println("= ?")
    print("Enter the Answer : ")
    var input = readLine();
    print("결과 : ")

    if(input?.toInt() == num1 + num2){
        println("정답입니다. ")
    }else{
        println("오답입니다. ")
    }

    // 선생님 풀이
    val sc2 : Scanner = Scanner(System.`in`)
    val rd : Random = Random()

    val num3 = rd.nextInt(50)+1
    val num4 = rd.nextInt(50)+1

    //Kotlin에서는 서로 다른 자료형끼리의 연산이 불가능 (자료형을 추론하기 때문)

    println("$num1 + $num2 = ?")
    print("Enter the answer : ")
    var answer = readLine()?.toInt()

    var result = if(num1 + num2 == answer) "정답입니다." else "오답입니다."
    println(result)

    // 예제문제2
    print("Enter the number : ")
    val inputNum = readln().toInt() //Int
    val result2 = if(inputNum > 0) "양수 값" else if(inputNum < 0) "음수 값" else "0"
    println(result2)

    // 코틀린에서는 null 값이 발생하는 경우에 대해 조치를 취해줘야 함
    // if문을 변수에 넣을 때에는 모든 조건을 만족하지 않았을 때도 생각해야 한다.
    // else문으로 닫아줘야 한다!
}