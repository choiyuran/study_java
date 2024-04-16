package javaStudy.week02.oop;

class TestClass {
    void instanceMethod() {}            // 인스턴스 메서드
    static void staticMethod() {}       // static 메서드

    void instanceMethod2() {
        instanceMethod();
        staticMethod();
    }

    static void staticMethod2() {
//        instanceMethod();               // 생성 시점의 차이
        // 프로젝트가 실행되고 클래스를 읽어들일 때, static이 붙어있는 필드나 메서드를 먼저 찾은 후 나머지를 읽어들이기 때문에
        // 이 시점에서는 instanceMethod()를 찾을 수 없음 [에러]
        staticMethod();
    }
}

public class TestClassMain {
    public static void main(String[] args) {

    }
}
