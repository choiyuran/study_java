package javaStudy.week02.oop;

public class VarArgs {
    public static void main(String[] args) {
        String[] strArr = {"100", "200", "300"};

        System.out.println(concatenate("", "100", "200", "300"));
        System.out.println(concatenate("-", strArr));
        System.out.println(concatenate(",", new String[]{"1", "2", "3"}));
        System.out.println("[" + concatenate(",", new String[0]) + "]");            // null
        System.out.println("[" + concatenate(",") + "]");           // null
    }
    static String concatenate(String delim, String... args) {           // 가변인자의 자료형은 Object를 많이 사용
        String result = "";
        for(String str : args) {
            result += str + delim;
        }
        return result;
    }

//    static String concatenate(String... args) {
//        return concatenate("", args);
//    }

}
