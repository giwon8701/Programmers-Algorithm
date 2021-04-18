import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/42889
 */
public class Programmers06_42889 {

    public static void main(String[] args) {
        int[] N = {5, 4, 5};
        int[][] stages = {
                {2, 1, 2, 6, 2, 4, 3, 3},
                {4, 4, 4, 4, 4},
                {1, 2, 3, 2, 1}
        };
        int i = 2;
        solution(N[i], stages[i]);
    }

    public static int[] solution(int N, int[] stages) {
        Map<Integer, Float> stages_failure = new HashMap<>(); // 스테이지별 실패율

        for (int stage=1; stage<=N; stage++) {
            int fail = 0;
            int success = 0;

            for (int user : stages) {
                if (stage == user) fail++; // 스테이지를 도전중인 사람 수
                else if (stage < user) success++; // 해당 유저가 현재 탐색중인 스테이지를 통과한 상태일 때 성공한 사람을 카운트해줌
            }

            float sum = success + fail; // 스테이지에 도전해본 유저수
            // 도전해본 유저수(분모)가 0일 때, 값을 0으로 해줌
            float failure = (sum == 0) ? 0 : fail / sum;
            stages_failure.put(stage, failure);
        }

        // Map의 <K,V>를 entry로 묶어줌
        List<Map.Entry<Integer, Float>> list = new ArrayList<>(stages_failure.entrySet());

        // list를 정렬해준다. (reverseorder() => 내림차순정렬)
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));


        int[] result = new int[N];
        for (int i=0; i<N; i++) {
            result[i] = list.get(i).getKey();
            System.out.println(list.get(i));
        }

        return result;
    }
}
