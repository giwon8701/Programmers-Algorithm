import java.util.ArrayList;
import java.util.List;

public class Programmers03_42840 {
    public static void main(String[] args) {

        int[] answer = {1, 2, 3, 4, 5};

        int[] res = solution(answer);
    }

    public static int[] solution(int[] answers) {
        int[] answer;
        int[][] supoja = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] cnt = new int[3]; // 몇개맞았는지 체크하는 함수

        for (int i=0; i<supoja.length; i++) {
            for (int j=0; j<answers.length; j++) {
                if (supoja[i][j % supoja[i].length] == answers[j]) cnt[i]++;
            }
        }

        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        List<Integer> list = new ArrayList<>(); // answer배열에 넣을 값이 들어감

        for (int i=0; i<cnt.length; i++) {
            if (cnt[i] == max) list.add(i+1);   // supoja[0]의 정답갯수가 max일때 list에 1 추가
        }

        answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
