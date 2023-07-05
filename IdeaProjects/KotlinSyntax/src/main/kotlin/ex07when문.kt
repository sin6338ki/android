fun main() {

    // 사용자로부터 국어, 영어, 수학, 과탐 점수를 입력받는다.
    // 국어 점수 >>
    // 영어 점수 >>
    // 수학 점수 >>
    // 과탐 점수 >>

    // 평균을 구하고, 총합을 구해서
    // run창에
    // 평균 : 90
    // 총합 : 350

    // 평균의 값에 따라서 등급 출력 --> when 문 사용하기
    // 90이상이면 'A'
    // 80이상이면 'B'
    // 70이상이면 'C'
    // 60이상이면 'D'
    // 그 외 'F'

    // 출력 형태
    // 등급 : 'A'

    print("국어 점수 >> ")
    val score1 : Int = readln().toInt()
    print("영어 점수 >> ")
    val score2 : Int = readln().toInt()
    print("수학 점수 >> ")
    val score3 : Int = readln().toInt()
    print("과탐 점수 >> ")
    val score4 : Int = readln().toInt()

    var total = score1 + score2 + score3 + score4
    var avg = total / 4

    println("평균 : $avg")
//    ${(a+b+c+d)/4} 로 작성할 수도 있음
    println("총합 : $total")

    var grade : String

    when(avg){
        in 60..69 -> grade = "D"
        in 70..79 -> grade = "C"
        in 80..89 -> grade = "B"
        in 90..100 -> grade = "A"
        else -> grade = "F"
    }

    println("등급 : $grade")



}