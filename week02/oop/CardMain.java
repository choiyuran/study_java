package javaStudy.week02.oop;

class Card {
    String kind;            // 인스턴스 변수, 필드, 속성, 상태
    int number;             // 인스턴스 변수
    static int width = 100;     // 클래스 변수 static(정적 변수)
    static int height = 250;    // 클래스 변수

    public Card(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }
}

public class CardMain {
    public static void main(String[] args) {
    Card card1 = new Card("Heart", 7);              // card1은 참조변수. "Heart"와 7이 인스턴스의 변수 (인스턴스 변수는 참조 변수에 종속적이다)
    Card card2 = new Card("Spade", 4);

    // 클래스 변수는 공통적인 속성을 정의할 때 사용하면 유용하다.
    // 클래스 변수는 클래스에 종속적이기 때문에 해당 클래스로 정의된 모든 인스턴스에 영향을 준다.
    Card.width = 80;
    Card.height = 200;


    }
}
