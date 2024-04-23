package javaStudy.week03.oop2;

public class InstanceofTest {
    public static void main(String[] args) {
        FireEngine fe = new FireEngine();           // 세개 다 만족
        // 이 경우는 두번째, 세번째 조건만 만족
//        Car car = new Car();
        // 이 경우는 세개 다 만족
//        Car car = new FireEngine();

        if(fe instanceof FireEngine) {
            System.out.println("This is a FireEngine instance.");
        }
        if(fe instanceof Car) {
            System.out.println("This is a Car instance.");
        }
        if(fe instanceof Object) {
            System.out.println("This is an Object instance.");
        }
        System.out.println(fe.getClass().getName());
    }
}
