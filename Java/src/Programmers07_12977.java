import java.util.*;

/*
소수 더하기
https://programmers.co.kr/learn/courses/30/lessons/12977
*/
public class Programmers07_12977 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4},
                {1, 2, 7, 6, 4},
        };
        int i = 1;

        System.out.println(solution(nums[i]));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        // 경우의수를 set에 싹 다 더함
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    list.add(nums[i]+nums[j]+nums[k]);
                }
            }
        }

        for (int num : list) {
            System.out.println("set : " + num);
            // true면 소수, 아니면 false
            boolean res = true;

            int i = 2;
            // 소수인지 판별함
            while (i * i <= num) {
                if (num % i == 0) {
                    res = false;    // 수가 나눠지면 false로 바꿔줌
                    i++;
                    break;
                }
            }

            // 소수(true)면 , answer를 증가시킴
            if (res) answer++;
        }

        return answer;
    }
}
