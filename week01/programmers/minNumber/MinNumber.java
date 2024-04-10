package javaStudy.week01.programmers.minNumber;

import java.util.*;
class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int index = 0;
        int[] SB = new int[B.length];
        for(int i = B.length; i > 0; i--) {
            SB[index++] = B[i-1];
        }

        for(int i = 0; i < A.length; i++) {
            answer += A[i] * SB[i];
        }
        return answer;
    }
}

public class MinNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        int answer = solution.solution(A, B);
        System.out.println(answer);
    }
}
