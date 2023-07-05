fun main() {

    // 레이블(label)
    outer@while (true){
        println("바깥쪽 while문이 동작")

        while(true){
            println("안쪽 while문이 동작")
            break@outer
            // 원하는 제어문을 빠져나갈 수 있도록 도와줌
            // @별칭을 작성해주면 원하는 곳으로 돌아간다
        }
    }

    print("숫자를 입력하세요 : ")
    var input = readLine()?.toInt()
    var result = 1
    while(true){

        if(input != null) {
            result *= input;
            input--
        }
        if(input == 0){
            break
        }
    }

    println("결과값 : $result")
}