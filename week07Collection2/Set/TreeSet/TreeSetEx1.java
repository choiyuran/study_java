package javaStudy.week07Collection2.set.treeSet;

import java.util.TreeSet;

public class TreeSetEx1 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();

        String from = "b";
        String to = "d";

        set.add("abc");     set.add("alien");   set.add("bat");
        set.add("Car");     set.add("car");     set.add("dzzzz");
        set.add("fan");     set.add("dance");

        System.out.println(set);
        System.out.println("range search : from " + from + " to " + to);
        System.out.println("result1 : " + set.subSet(from, to));    // 범위에 포함된 것을 가져옴(포함, 불포함)
        System.out.println("result2 : " + set.subSet(from , to + "zzz"));
        // 대문자가 소문자보다 작다.
    }
}
