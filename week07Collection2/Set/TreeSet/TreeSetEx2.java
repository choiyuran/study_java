package javaStudy.week07Collection2.set.treeSet;

import java.util.TreeSet;

public class TreeSetEx2 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        int[] score = {80, 95, 90, 50, 35, 65, 45, 100};

        for(int i = 0; i < score.length; i++) {
            set.add(new Integer(score[i]));
        }

        System.out.println("50보다 작은 값 : " + set.headSet(new Integer(50)));
        System.out.println("50보다 작은 값 : " + set.headSet(new Integer(50), true));
        System.out.println("50보다 큰 값 : " + set.tailSet(new Integer(50), false));
    }
}
