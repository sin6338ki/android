fun main() {

    // Map
    // Python dictionary, Json -- > key, value 쌍으로 이루어진 데이터 자료형
    val K = mutableMapOf<Int, String>()
    // 데이터를 입력하는 기능 : put
    // put : key, value
    K.put(1, "지영")
    K.put(2, "하루")
    K.put(3, "종일")
    // key 값만 확인해보기
    // value 값만 확인해보기
    // key, value 둘다 확인해보기
    for(i in K){
        println(i)
        println(i.key)
        println(i.value)
    }

    // Set : 중복되는 데이터를 없애주는 기능을 가지고 있음
    val list = mutableSetOf("a", "b", "c")
    // add
    list.add("d")
    list.add("c")
    list.add("a")
    print(list)
}