package javaStudy.week14.lambda;

@FunctionalInterface
interface  MyFunction3 {
    void myMethod();
}

class Outer {
    int val = 10;   // Outer.this.val

    class Inner {
        int val = 20;        // this.val

        void method(int i) {          
            int val = 30;
            
            // 람다식에서 사용하는 매개변수와 지역변수는 상수 취급(final)
            MyFunction3 f = () -> {
                System.out.println("             i : " + i);  // method 메서드의 매개변수 i를 참조
                System.out.println("           val : " + val);  // method 메서드 내의 지역 변수 val을 참조
                System.out.println("      this.val : " + ++this.val);  // Inner 클래스의 인스턴스 변수 val을 참조
                System.out.println("Outer.this.val : " + ++Outer.this.val);  // Outer 클래스의 인스턴스 변수 val을 참조
            };
            f.myMethod();
        }
    }   // Inner클래스의 끝
}       // Outer클래스의 끝

public class LambdaEx3 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);
    }
}
