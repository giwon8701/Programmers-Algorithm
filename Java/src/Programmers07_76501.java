/*
음양 더하기
https://programmers.co.kr/learn/courses/30/lessons/76501
*/
public class Programmers07_76501 {
    public static void main(String[] args) {
        int[][] absolutes = {
                {4, 7, 12},
                {1, 2, 3}
        };
        boolean[][] signs = {
                {true, false, true},
                {false, false, true}
        };

        int i = 1;
        System.out.println(solution(absolutes[i], signs[i]));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i=0; i<absolutes.length; i++) {
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }

        return answer;
    }
}
