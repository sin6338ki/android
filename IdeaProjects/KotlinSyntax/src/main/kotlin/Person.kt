class Person constructor(name:String, age:Int) {

    // 프로퍼티(Property)
    // : 필드 + getter/setter = 프로퍼티
    // - 모든 프로퍼티는 고정된 초깃값을 가져야 한다.

    val name : String
    var age : Int

    init {
        this.name = name
        this.age = age
    }

    // init : 객체 생성과 동시에 가장 먼저 실행이 되는 코드
    //        딱 한 번 실행이 되는 코드

    init {
        //새로운 생성자를 만드는 것이 가능하다!
    }

    // 1. 프로퍼티를 val로 선언할 경우 getter만 생성된다. 
    // 2. 프로퍼티를 var로 선언할 경우 가변할 수 있기 때문에 
    //    getter, setter가 같이 생성된다!

    // 주생성자를 만들게 되면 getter/setter 즉,
    // 프로퍼티의 역할도 같이함


}