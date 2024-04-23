package javaStudy.week03.oop2;

//문제: 은행 계좌 관리 시스템
//은행 계좌 관리 시스템을 구현하기 위해 다음 조건을 만족하는 자바 프로그램을 작성하세요.
//
//조건:
//
//계좌(Account) 슈퍼클래스:
//모든 계좌는 계좌번호(accountNumber)와 잔액(balance), 예금주 속성을 가집니다.
//입금(deposit) 메소드와 출금(withdraw) 메소드를 구현합니다. 출금 시 잔액이 부족하면 출금을 할 수 없습니다.
//계좌 정보를 출력하는 printAccountInfo() 메소드를 구현합니다.
//
//저축 계좌(SavingsAccount)와 체크 계좌(CheckingAccount) 서브클래스:
//저축 계좌는 이자율(interestRate)를 추가 속성으로 가집니다.
//체크 계좌는 수수료(fee)를 추가 속성으로 가집니다.
//각 클래스는 상속받은 출금 메소드를 오버라이딩합니다. 저축 계좌는 출금 시 출금 금액에 대한 이자를 계산하여 잔액에 반영하고, 체크 계좌는 출금 시 수수료를 차감합니다.
//각 클래스는 상속받은 계좌 정보 출력 메소드도 오버라이딩하여 추가 속성 정보를 출력합니다.
//계좌 관리(Manager) 인터페이스:
//
//계좌 생성(createAccount), 계좌 삭제(deleteAccount), 전체 계좌 목록 출력(printAllAccounts) 메소드를 정의합니다.
//
//은행(Bank) 클래스:
//계좌 관리 인터페이스를 구현합니다.
//여러 계좌를 관리할 수 있도록 내부적으로 Account 객체의 리스트를 유지합니다.
//계좌 생성 시 저축 계좌와 체크 계좌 중 선택하여 생성할 수 있도록 오버로딩된 createAccount 메소드를 제공합니다.
//
//요구 사항:
//각 클래스와 인터페이스의 상세 구현을 완성하세요.
//간단한 실행 예제(main 메소드)를 포함하여, 생성한 계좌에 대해 입금, 출금, 및 계좌 정보 출력을 시험해 보세요.
//        인터페이스와 오버라이딩, 오버로딩 개념을 활용하여 유연성과 확장성을 고려한 설계를 하세요.
//이 문제는 객체 지향 프로그래밍의 핵심 개념인 상속, 오버라이딩, 인터페이스 구현, 그리고 오버로딩을 종합적으로 활용하여 실생활 문제를 해결하는 데 도움이 될 것입니다. 문제 해결 과정에서 각 개념을 어떻게 효과적으로 사용할 수 있는지에 대한 이해도를 높일 수 있을 것입니다.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    String accountNumber;   // 계좌번호
    Long balance;           // 잔액
    String name;            // 예금주

    public Account(String accountNumber, Long balance, String name) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
    }

    // 입금
    public void deposit(Long money) {
        balance += money;
        System.out.println(money + "원이 입금되었습니다. 잔액은" + balance + "원 입니다.");
    }
    
    // 출금
    public void withdraw(Long money) {
        if(balance < money) {
            System.out.println("잔액이 부족합니다.");
        }
        else {
            System.out.println(money + "원이 출금되었습니다.");
            balance -= money;
        }
    }
}

class SavingsAccount extends Account{
    Double interestRate;           // 이자율


    public SavingsAccount(String accountNumber, Long balance, String name, Double interestRate) {
        super(accountNumber, balance, name);
        this.interestRate = interestRate;
    }

    // 출금
    @Override
    public void withdraw(Long money) {
        double d = money * (interestRate / 100);            // 출금할 돈에 대한 이자율 계산
        long l = (long)d;                                   // long 타입으로 형변환
        money += l;                 // 출금할 금액과 이자율의 합
        balance -= money;           // 이자율을 합한 최종 금액을 뺌
    }

    @Override
    public String toString() {
        return "저축 계좌 : {" +
                "accountNumber = '" + accountNumber + "'" +
                ", balance = '" + balance + '\'' +
                ", name = '" + name + "'" +
                ", interestRate = '" + interestRate + '\'' +
                "}";
    }
}

class CheckingAccount extends Account {
    Long fee;                       // 수수료

    public CheckingAccount(String accountNumber, Long balance, String name, Long fee) {
        super(accountNumber, balance, name);
        this.fee = fee;
    }

    // 출금
    @Override
    public void withdraw(Long money) {
        money += fee;
        balance -= money;
    }

    @Override
    public String toString() {
        return "체크 계좌 : {" +
                "accountNumber = '" + accountNumber + "'" +
                ", balance = '" + balance + '\'' +
                ", name = '" + name + "'" +
                ", fee = '" + fee + '\'' +
                "}";
    }
}

interface Manager{
    public abstract Account createAccount();       // 계좌 생성
    public abstract void deleteAccount(Account account);       // 계좌 삭제
    public abstract void printAllAccounts();    // 전체 계좌 목록 출력
}

class Bank implements Manager {
    List<Account> lists = new ArrayList<>();

    @Override
    public Account createAccount() {
        System.out.print("생성할 계좌 종류를 선택해주세요. 1번 저축 계좌 2번 체크 계좌 : ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        System.out.print("이름을 입력하세요 : ");
        String name = sc.nextLine();
        
        System.out.print("계좌번호를 입력하세요 : ");
        String accountNum = sc.nextLine();

        System.out.print("잔액을 입력하세요 : ");
        Long balance = Long.parseLong(sc.nextLine());

        Account account = null;
        if(s.equals("1")) {
            System.out.print("이자율을 입력하세요 : ");
            Double interestRate = Double.parseDouble(sc.nextLine());
            SavingsAccount saving = new SavingsAccount(accountNum, balance, name, interestRate);
            lists.add(saving);
            account = saving;
        }
        if(s.equals("2")) {
            System.out.print("수수료를 입력하세요 : ");
            Long fee = Long.parseLong(sc.nextLine());
            CheckingAccount checking = new CheckingAccount(accountNum, balance, name, fee);
            lists.add(checking);
            account = checking;
        }
        return account;
    }

    @Override
    public void deleteAccount(Account account) {
        System.out.println("계좌가 삭제되었습니다.");
        lists.remove(account);
    }

    @Override
    public void printAllAccounts() {
        for(Account account : lists) {
            System.out.println(account);
        }
    }
}

public class Quiz1 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Account account = bank.createAccount();
        Account account2 = bank.createAccount();
        System.out.println("<< 계좌 목록 >>");
        bank.printAllAccounts();

        System.out.println("==========================================================================");
        bank.deleteAccount(account);
        System.out.println();

        System.out.println("<< 삭제 후 계좌 목록 >>1");
        bank.printAllAccounts();
    }
}
