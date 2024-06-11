package javaStudy.week08.enums;

public class CardEx3 {
    enum Kind {
        CLOVER, HEART, DIAMOND, SPADE
    }

    public static void main(String[] args) {
        String kindName = "HEART";

        try {
            Kind kind = Kind.valueOf(kindName);
            System.out.println("valueOf로 얻은 상수: " + kind);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 enum 상수 이름: " + kindName);
        }

        // 잘못된 상수 이름 예제
        kindName = "heart";

        try {
            Kind kind = Kind.valueOf(kindName);
            System.out.println("valueOf로 얻은 상수: " + kind);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 enum 상수 이름: " + kindName);
        }
    }
}