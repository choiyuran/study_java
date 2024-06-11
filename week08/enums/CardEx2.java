package javaStudy.week08.enums;
class Card2 {
    // Enum definitions for kind and value
    enum Kind {CLOVER, HEART, DIAMOND, SPADE}
    enum Value {
        ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4);

        private final int number;

        Value(int number) {
            this.number = number;
        }

        int getNumber(){
            return number;
        }
    }

    // Final fields for kind and value
    final Kind kind;
    final Value value;

    // Constructor to initialize kind and value
    public Card2(Kind kind, Value value) {
        this.kind = kind;
        this.value = value;
    }

    // Override toString method for better readability
    @Override
    public String toString() {
        return "Card{" + "kind=" + kind + ", value=" + value + "("+value.getNumber()+")"+'}';
    }

}
public class CardEx2 {
    public static void main(String[] args) {
        Card2 card = new Card2(Card2.Kind.HEART, Card2.Value.THREE);
        System.out.println(card); // Output: Card{kind=HEART, value=THREE}
    }
}