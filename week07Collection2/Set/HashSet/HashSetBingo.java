package javaStudy.week07Collection2.set.hashSet;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetBingo {
    public static void main(String[] args) {
        // HashSet은 저장된 순서를 보장하지 않고, 자체적인 저장 방식에 따라 순서가 결정됨.
        // LinkedHashSet은 저장된 순서를 보장하기 때문에 정렬되지 않은 상태로 출력.
//        Set set = new HashSet();
        Set set = new LinkedHashSet();
        int[][] board = new int[5][5];

        for(int i = 0; set.size() < 25; i++) {
            set.add((int)(Math.random() * 50) + 1);
        }
        Iterator it = set.iterator();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = (Integer)it.next();
                System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
            }
            System.out.println();
        }
    }
}
