package javaStudy.week06Collection;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Iterator it = list.iterator();

        while(it.hasNext()) {
            Object o = it.next();
            System.out.println(o);
        }
    }
}
