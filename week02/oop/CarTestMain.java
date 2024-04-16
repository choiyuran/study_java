package javaStudy.week02.oop;

class Car {
    String color;       // 색상
    String gearType;     // 변속기 종류
    int door;

    Car() {
        this("white", "auto", 4);
    }

    Car(Car c) {
        color = c.color;
        gearType = c.gearType;
        door = c.door;
    }

    public Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", gearType='" + gearType + '\'' +
                ", door=" + door +
                '}';
    }
}

public class CarTestMain {
    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car(c1);
        System.out.println("c1 : " + c1 + "\n" + "c2 : " + c2);
        c1.door = 100;
        System.out.println("c1 : " + c1 + "\n" + "c2 : " + c2);
    }
}
