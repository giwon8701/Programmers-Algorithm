import java.util.HashMap;
/*
https://programmers.co.kr/learn/courses/30/lessons/42862
 */
public class Programmers09_42862 {
    public static void main(String[] args) {

        int[] n = {5, 5, 3};
        int[][] lost = {
                {2, 4},
                {2, 4},
                {3}
        };
        int[][] reserve = {
                {1, 3, 5},
                {3},
                {1}
        };

        int i = 0;
        System.out.println(solution(n[i], lost[i], reserve[i]));

    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // key : 학생번호,  val : 체육복갯수
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=1; i<=n; i++) map.put(i, 1);
        map.put(0, 0);
        map.put(n+1, 0);

        // 도난당한 사람들은 체육복 갯수 -1
        for (int i: lost) map.replace(i, map.get(i)-1);
        // 여분이 있는 사람들은 체육복 갯수 +1
        for (int i: reserve) map.replace(i, map.get(i)+1);

        for (int i=1; i<=n; i++) {
            if (map.get(i) == 0) {
                if (map.get(i-1) == 2) {    // 앞번호에게 먼저 빌려보고
                    map.replace(i, 1);
                    map.replace(i-1, 1);
                } else if (map.get(i+1) == 2) { // 앞번호가 없으면 뒷번호에게 빌린다.
                    map.replace(i, 1);
                    map.replace(i+1, 1);
                }
            }
        }

        for (int i: map.values()) {
            if (i > 0) answer++;
        }

        return answer;
    }
}