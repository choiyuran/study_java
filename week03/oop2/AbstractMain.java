package javaStudy.week03.oop2;

abstract class Player {
    boolean pause;                      // 일시정지 상태를 저장하기 위한 변수
    int currentPos;                     // 현재 Play되고 있는 위치를 저장하기 위한 변수
    abstract void play(int pos);        // 추상메서드
    abstract void stop();               // 추상메서드

    public Player() {           // 추상 클래스도 생성자가 있어야 한다
        pause = false;
        currentPos = 100;
    }

    void play() {
        play(currentPos);       // 추상 메서드를 사용할 수 있다.
    }
    void pause() {
        if(pause)  {                // pause가 true일 때 (정지상태)에서 pause가 호출되면,
            pause = false;          // pause의 상태를 false로 바꾸고,
            play(currentPos);       // 현재의 위치에서 play를 한다.
        }
        else {                      // puase가 false일 때 (play상태)에서 pause가 호출되면,
            pause = true;           // pause의 상태를 true로 바꾸고,
            stop();                 // play를 멈춘다.
        }
    }
}
class AudioPlayer extends Player {
    void play(int pos) {
        this.pause = false;             // 일시정지 false = 재생중
        System.out.println("AudioPlayer 에서 재생");
    };
    void stop() {
        this.pause = !this.pause;       // 재생/일시정지 뒤집기
        if(this.pause) {                // 일시정지 중이면
            System.out.println("일시정지");
        }else {                         // 재생중이면
            System.out.println("재생중");
        }
    }
}

abstract class AbstractPlayer extends Player{
    void play(int pos) {
        play(pos);
    }
}

public class AbstractMain {
    public static void main(String[] args) {
        Player player = new AudioPlayer();
        // 부모의 일반 메서드인 play() 호출
        // 일반 메서드 play()안에 추상메서드 play(currentPos)호출
        // 자식에서 정의한 추상메서드 play(int pos)호출
        player.play();
        player.stop();
        player.stop();
        player.stop();
        player.stop();
    }
}
