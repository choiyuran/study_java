package javaStudy.week08.enums;

class Card {
    enum Kind { CLOVER, HEART, DIAMOND, SPADE }     // 열거형 Kind를 정의
    enum Value { TWO, THREE, FOUR }     // 열거형 Value를 정의

    final Kind kind;
    final Value value;

    // Card 생성자
    Card(Kind kind, Value value) {
        this.kind = kind;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "kind=" + kind +
                ", value=" + value +
                '}';
    }
}

public class CardEx {
    public static void main(String[] args) {
        // Card 객체 생성
        Card card1 = new Card(Card.Kind.HEART, Card.Value.THREE);
        Card card2 = new Card(Card.Kind.SPADE, Card.Value.TWO);

        // Card 객체 출력
        System.out.println(card1);
        System.out.println(card2);
    }
}