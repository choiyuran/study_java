package javaStudy.week08.generics;

import java.util.ArrayList;
class FruitBox<T> extends Box<T>{
    ArrayList<T> list = new ArrayList<T>();
}
class Box<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item) {list.add(item);}
    T get(int i) {return list.get(i);}

    ArrayList<T> getList() {return list; }

    int size() { return list.size(); }

    @Override
    public String toString() {
        return "Box{" +
                "list=" + list +
                '}';
    }
}

class Fruit{}
class Apple extends Fruit{}
class Grape extends Fruit{}


public class BoxEx {
    public static void main(String[] args) {
        // 제네릭 클래스의 Box<T>의 선언
        Box<Apple> appleBox = new Box<Apple>();
//    Box<Apple> appleBox2 = new Box<Grape>(); // 에러 발생
//    Box<Fruit> appleBox3 = new Box<Apple>(); // 에러 발생

        // 두 제네릭 클래스가 상속 관계이고, 대입된 타입이 일칠하는것은 OK
        Box<Apple> appleBox4 = new FruitBox<Apple>();
        Box<Apple> appleBox5 = new Box<>();

        // - 대입된 타입과 다른 타입의 객체는 추가할 수 없다.
        Box<Apple> appleBox6 = new Box<Apple>();
        appleBox6.add(new Apple());
        System.out.println(appleBox6);
//        appleBox6.add(new Grape());// 에러
    }
}
