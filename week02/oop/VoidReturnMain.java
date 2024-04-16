package javaStudy.week02.oop;

class VoidReturn {
    void returnTest() {
        for(int i = 0; i < 5; i++) {
            System.out.println(i);
            if(i == 3) {
                return;             // 함수 아예 종료
            }
        }
    }
}

public class VoidReturnMain {
    public static void main(String[] args) {
        VoidReturn voidReturn = new VoidReturn();
        voidReturn.returnTest();
    }
}
