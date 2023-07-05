fun main() {
    // 기본 자료형
    // Int, Float, Double, Char, Boolean..
    // 우선은 객체 자료형으로 선언하지만 저장하는 값을 보고
    // 기본 자료형임을 추론해서 정적인 공간(int)에 저장
    val age : Int = 20

    // 참조 자료형
    // String, Person, Member...
    // + String?, Int?, Float?... (기본자료형+?)
    // String과 String?은 엄연히 다른 자료형!!
    // String? ----> 해당 변수에는 문자열이 저장될수도 있고
    //               Null값이 저장될 수도 있음
    val name : String? = null
    // String에는 무조건 문자열만 들어갈 수 있음. null을 허용하지 않음
    // String?에는 문자열/null 가능
    println(name?.length)
//    println(name!!.length)

    // null을 처리하는 3가지 방법
    // null을 허용하는 순간 해당 변수에 대해 아래쪽에서 null 처리를 해줘야 함

    // 1) ? (safe-call) : 세이프콜
    //  - name?.length : name.lengh가 가져오는 결과값이 null일 수 있음
    //  null이 들어오면 null값을 호출 --> 안전하게 호출

    // ---> RecyclerView에서 View를 리턴할 때 사용. 웬만하면 사용하지 말것!
    // !!를 사용하면 반드시 사용한 이유를 작성해줘야 한다.
    // 2) !! (not-null asserted) : 단정기호
    //  - name.length는 절대로 null일 수가 없음을 단정
    // null이 들어와버리며 NPE(null point exception)을 발생시킴

    // 3) ?: (엘비스(Elvis) 연산자)
    // 자바의 삼항연사자와 유사
    println(name?.length ?: "이름이 null입니다.")
    //name.lengh가 null값을 가져오면 ?: 오른쪽에 있는 내용을 출력함

}