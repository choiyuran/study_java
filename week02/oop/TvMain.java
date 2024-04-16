package javaStudy.week02.oop;

class TV{
    private int channel;        // 채널
    private String name;        // 티비 이름
    private int volume;         // 볼륨

    public TV(int channel, String name, int volume) {
        this.channel = channel;
        this.name = name;
        this.volume = volume;
    }

    // 채널 Up
    public void channelUp() {
        channel++;
    }

    // 채널 Down
    public void channelDown() {
        channel--;
    }

    // 입력한 채널로 이동
    public void selectChannel(int channel) {
        this.channel = channel;
    }

    // 볼륨 Up
    public void volumeUp() {
        volume++;
    }

    // 볼륨 Down
    public void volumeDown() {
        volume--;
    }

    @Override
    public String toString() {
        return "TV{" +
                "channel=" + channel +
                ", name='" + name + '\'' +
                ", volume=" + volume +
                '}';
    }
}


public class TvMain {
    public static void main(String[] args) {
//        TV arr[] = new TV[5];             // 객체 배열이기 때문에 참조하는 것이 없는 경우 null로 출력
//        int[] arr = new int[5];           // 참조 타입이 아닌 경우는 기본 값(0)이 출력. null 없음.
        TV[] arr = new TV[3];

        TV tv1 = new TV(1,"tv1",10);
        TV tv2 = new TV(2, "tv2", 9);
        TV tv3 = new TV(3, "tv3", 6);

        arr[0] = tv1;
        arr[1] = tv2;
        arr[2] = tv3;

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
