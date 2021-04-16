import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/42889
 */
public class Programmers11_42889 {

    public static void main(String[] args) {
        int[] N = {5, 4};
        int[][] stages = {
                {2, 1, 2, 6, 2, 4, 3, 3},
                {4, 4, 4, 4, 4}
        };
        int i = 0;
        solution(N[i], stages[i]);
    }

    public static int[] solution(int N, int[] stages) {
        int answer[] = new int[N];
        Map<Float, Float> stages_failure = new TreeMap<>(); // 스테이지별 실패율
        int[] fail = new int[N];
        int[] success = new int[N];

        for (int stage=1; stage<=N; stage++) {
            for (int user : stages) {
                // 스테이지를 도전중인 사람 수
                if (stage == user) fail[stage - 1]++;

                // 해당 유저가 현재 탐색중인 스테이지를 통과한 상태일 때 성공한 사람을 카운트해줌
                if (stage < user) success[stage - 1]++;
            }

            float failure = (float) fail[stage - 1] / (float) (success[stage - 1] + fail[stage - 1]);
            stages_failure.put(stage, failure);
        }

        for (int i=1; i<=N; i++) {
            System.out.println(stages_failure.get(i));
        }

        List<Integer> arrList = new ArrayList<>(stages_failure.keySet());
        Collections.sort(arrList, (k, v) -> stages_failure.get(k.compareTo(stages_failure.get(v))));





        return null;
    }
}
