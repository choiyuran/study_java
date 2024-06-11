package javaStudy.week07Collection2.set.hashSet;

import java.util.HashSet;
import java.util.Set;

class Person2 {
    String name;
    int age;

    Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Person2) {
            Person2 tmp = (Person2) o;
            return name.equals(tmp.name) && age == tmp.age;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    //    @Override
//    public int hashCode() {
//        return (name+age).hashCode();
//    }

    @Override
    public String toString() {
        return name + ":" + age;
    }
}

public class HashSetEx4 {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new String("abc"));
        set.add(new String("abc"));
        set.add(new Person2("David", 10));
        set.add(new Person2("David", 10));

        System.out.println(set);
    }
}
