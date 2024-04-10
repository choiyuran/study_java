package javaStudy.week01.programmers.iMake;
import java.util.Arrays;

class Solution {
    public String solution(String myString) {
        char c = 'l';
        int lnum = (int)c;
        for(int i = 0; i < myString.length(); i++) {
            int n = (int)myString.charAt(i);
            if(n < lnum) {
                myString = myString.replace(myString.charAt(i), c);
            }
        }
        return myString;
    }
}

public class IMake {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String myString = "abcdevwxyz";
        String answer = solution.solution(myString);
        System.out.println(answer);
    }
}
