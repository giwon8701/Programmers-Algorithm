import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
https://programmers.co.kr/learn/courses/30/lessons/42889
 */
public class Programmers11_42889 {

    public static void main(String[] args) {

    }

    public static int[] solution(int N, int[] stages) {
        int[] answer= new int[N];
        Map<Integer, Integer> fail = new HashMap<>();
        fail.put(0, 0);
        fail.put(N+2, 0);
        Map<Integer, Integer> clearUserNum = new HashMap<>();
        Map<Integer, Integer> tryingUserNum = new HashMap<>();
        for (int i=0; i<N; i++) {
            clearUserNum.put(i, 0);
        }

        for (int stage=1; stage<=N; stage++) {
            int clearCnt = 0;
            int tryingCnt = 0;
            for (int trying : stages) {
                if (trying > stage) clearCnt++;
                if (trying <= stage) tryingCnt++;
            }
            clearUserNum.replace(stage, clearUserNum.get(stage)+clearCnt);
            tryingUserNum.replace(stage, tryingUserNum.get(stage)+tryingCnt);
        }

        for (int i=1; i<=N; i++) {
            if (clearUserNum.get(i) == 0) {
                fail.put(i, 0);
            } else {
                fail.put(i, tryingUserNum.get(i) / clearUserNum.get(i));
            }
        }


        for(int i=1; i<=fail.size(); i++) {
            for (int j=1; j<fail.size(); j++) {
                if (fail.get(i) > fail.get(j)) {

                }
            }
        }



        return answer;
    }
}
