fun main() {

    // 사용자가 입력한 값이 1인지 2인지 또는 1, 2가 아닌지 판단
    // when문
    // when(값){
    //      값1 -> 실행코드1
    //      값2 -> 실행코드2
    //      else -> 실행코드3
    // }

    print("1 또는 2를 입력해주세요 >> ")
    val num : Int = readln().toInt()

    when(num){
        1,2 -> println("num은 1 또는 2입니다.")
        3,4,5,6 -> println("num은 3,4,5,6 중 하나입니다.")
        else -> println("num은 0보다 작거나 6보다 큰 수")
    }
    
    // 범위를 when문을 사용해서 판단
    // 내가 입력한 숫자가 1-10인지 11-20인지 확인 
    // in 숫자1 .. 숫자2 : 숫자의 범위를 설정할 수 있는 키워드 
    // 숫자1 <=     <= 숫자2
    when(num){
        in 1..10 -> println("1과 10사이의 숫자입니다.")
        in 11..20 -> println("11과 20사이의 숫자입니다.")
        else -> println("0보다 작거나 20보다 큰 숫자입니다.")
    }
}