package javaStudy.week02.oop;

class Car2 {
    String color;
    int door;
    void drive() {
        System.out.println("drive, Brrrr~");
    }
    void stop() {
        System.out.println("stop!!!");
    }
}

class FireEngine extends Car2 {
    void water() {
        System.out.println("warter!!!");
    }

    @Override
    public String toString() {
        return "FireEngine{" +
                "color='" + color + '\'' +
                ", door=" + door +
                '}';
    }
}

class Ambulance extends Car2 {
    void siren() {
        System.out.println("siren~~~");
    }
}

public class Hire {
    public static void main(String[] args) {
        FireEngine f = new FireEngine();
        Ambulance a = new Ambulance();

//    a = (Ambulance)f;           // 에러 자식끼리는 형 변환 불가능(형태가 같아도 불가능)ㄴㄴㄴ
//    f = (Ambulance)a;           // 에러

        Car2 car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        car = fe;                  // 업캐스팅.(Car2)fe 형변환 생략 가능 = Car2 car = new FireEngine();
        fe2 = (FireEngine)car;     // 다운캐스팅. 형변환 생략 불가 [자식 인스턴스를 가져야 다운캐스팅 가능] Car2 car = new Car();는 불가능
        System.out.println(fe2);

    }
}
