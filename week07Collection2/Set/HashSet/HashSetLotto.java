package javaStudy.week07Collection2.set.hashSet;

import java.util.*;

public class HashSetLotto {
    public static void main(String[] args) {
        Set set = new HashSet();
        for(int i = 0; set.size() < 6; i++) {
            int num = (int)(Math.random() * 45) + 1;
            set.add(new Integer(num));
        }

        List list = new LinkedList<>(set);              // LinkedList(Collection c)
//        Collections.sort(list);                 // Collections.sort(List list) - 오름차순
//        Collections.sort(list, ((o1, o2) -> (Integer)o2 - (Integer)o1));        // 내림차순(람다식 사용)
        Collections.sort(list, new Comparator<Integer>(){                         // 내림차순(풀어서 사용했을 때)
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(list);
    }
}
