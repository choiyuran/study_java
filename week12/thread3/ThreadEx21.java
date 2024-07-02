package javaStudy.week12.thread3;

public class ThreadEx21 {
    public static void main(String[] args) {
        Runnable r = new RunnableEx21();
        new Thread(r).start();          // ThreadGroup에 의해 참조되므로 gc(가비지 컬렉션)대상이 아니다.
        new Thread(r).start();          // ThreadGroup에 의해 참조되므로 gc대상이 아니다.
    }
}

class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    // synchronized를 사용하지 않았기 때문에 하나의 쓰레드가 실행하는 중에 다른 쓰레드가 관여할 수 있다.
    // 그래서 하나의 쓰레드가 '잔액 - 출금할 돈'을 계산하기 전에 다른 쓰레드에서 같은 계산을 먼저 해버리면
    // balance의 값이 음수가 되는 경우가 생긴다.
    // ex) 쓰레드1이 잔액 200에서 100을 출금할 경우와 쓰레드2에서 200을 출금할 경우에
    // 쓰레드1이 실행되는 과정에서 쓰레드2가 200-200을 먼저 실행해버리면
    // 쓰레드1은 0-100을 하게 되니까 -100이라는 음수가 나오게 된다.
    public void withdraw(int money) {           
        if(balance >= money) {
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            balance -= money;
        }
    }   // withdraw
}

class RunnableEx21 implements Runnable {
    Account acc = new Account();

    public void run() {
        while(acc.getBalance() > 0) {
            // 100, 200, 300중의 한 값을 임의로 선택해서 출금(withdraw)
            int money = (int)(Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance : " + acc.getBalance());
        }
    }     // run()
}