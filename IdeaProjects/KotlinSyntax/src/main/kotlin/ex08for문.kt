fun main() {

    // 1~10까지 숫자를 출력
    // 1 2 3 4 5 6 7 8 9 10
    for(i in 1..10){
        print("$i ")
    }

    // 10~1까지 출력
    // 10 9 8 7 6 5 4 3 2 1
    // in downTo
    for(i in 10 downTo 1){
        print("$i ")
    }

    // step : i의 증가 보폭을 정해줄 수 있다!
    for(i in 1..20 step 3){
        print("$i ")
    }
}