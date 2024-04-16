package javaStudy.week02.oop;

public class FactorialMain {
    public static void main(String[] args) {
        int result = factorial(4);
        System.out.println(result);
    }

    static int factorial(int n) {           // static : 객체를 생성하지 않고도 접근 가능      ex) Student stu = new Student();일때 앞의 stu가 객체, new Student()가 인스턴스
        int result = 0;
        if(n == 1) result = 1;              // 한 줄일 경우에는 괄호 생략 가능(블럭 생략 가능)
        else result = n * factorial(n-1);
        return result;
    }
}
