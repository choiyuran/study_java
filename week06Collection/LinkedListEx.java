package javaStudy.week06Collection;

import java.util.LinkedList;

public class LinkedListEx {
    public static void main(String[] args) {
        LinkedList<String> aList = new LinkedList<String>();

        String[] alpha = {"A", "B", "C","D", "E"};
        for(String s : alpha) {
            aList.add(s);
        }

        System.out.println(aList);
        System.out.println();

        // 첫번째 위치에 항목을 추가
        aList.addFirst("AA");

        // 마지막 위치에 항목을 추가
        aList.addLast("BB");
        System.out.println("aList : " + aList);
        System.out.println();

        // peak, poll 테스트(
        System.out.println("aList의 첫번째 항목(peak()) : " + aList.peek());
        System.out.println("aList : " + aList);
        System.out.println();
        System.out.println("aList의 첫번째 항목(poll()) : " + aList.poll());          // 제거하면서 제거하는 문자를 보여줌.
        System.out.println("aList : " + aList);
    }
}
