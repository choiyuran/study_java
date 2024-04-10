package javaStudy.week01.programmers.picture;

import java.util.Arrays;

class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        int index = 0;
        for(int i = 0; i < picture.length; i++) {
            String s = "";
            for(int j = 0; j < picture[i].length(); j++) {
                for(int n = 0; n < k; n++) {
                    s += picture[i].charAt(j);
                }
            }
            for(int c = 0; c < k; c++) {
                answer[index++] = s;
            }
        }
        return answer;
    }
}


public class Picture {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] picture = {".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."};
        int k = 2;
        String[] answer = solution.solution(picture, k);
        System.out.println(Arrays.toString(answer));
    }
}
