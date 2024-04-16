package javaStudy.week02.oop;

class Person {
    private int weight;
    private String name;

    public Person(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public void diet(int weight) {
        this.weight -= weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person(73,"홍길동");
        p.diet(5);
        System.out.println(p);

    }
}
