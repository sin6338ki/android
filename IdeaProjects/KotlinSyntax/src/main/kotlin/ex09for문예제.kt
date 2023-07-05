fun main() {
    var sumOdd = 0
    var sumEven = 0

    for(i in 1..100 step 2) sumOdd += i

    for(i in 2..100 step 2) sumEven += i

    println("홀수의 합 : $sumOdd")
    println("짝수의 합 : $sumEven")
}