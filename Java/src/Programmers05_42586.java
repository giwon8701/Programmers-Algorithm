import java.util.*;

public class Programmers05_42586 {
    public static void main(String[] args) {

        int[][] progresses = {
                {93, 30, 55},
                {95, 90, 99, 99, 80, 99}
        };
        int[][] speeds = {
                {1, 30 ,5},
                {1, 1, 1, 1, 1, 1}
        };

        solution(progresses[0], speeds[0]);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer_list = new ArrayList<>();
        Queue<Integer> days= new LinkedList<>();
        double day = 0;


        for (int i=0; i<progresses.length; i++) {
            // progresses + speeds*day = 100%
            //    30      +   30 * x   = 100%
            // day = ((100-progress) / speeds) -> 값을 올림(ceil)해줘야 며칠걸리는지 나옴
            //  x  =  (100-30) / 30 = 70 / 30 =  7/3 = 2.xxxxxxx -> 2일이상 -> 올림 -> 3일
            day = (double)(100-progresses[i]) / (double)speeds[i];
            days.add((int)Math.ceil(day));
        }
        System.out.println(days);

        int temp = days.remove();   // 가장 앞의것을 삭제 및 반환
        int sum = 1;
        int i = 0;
        while(true) {
            //  현재 progress보다 다음 progress가 더 빠를때
            if (temp >= days.element()) {       // queue.element() = stack.peek()
                sum++;
                i++;
                if (days.size() == 1) {
                    answer_list.add(sum);
                    break;
                }
                days.remove();

            } else {
                answer_list.add(sum);
                temp = days.element();
                i = 0;
                sum = 0;
            }
            System.out.println("days: " + days + ", sum: " + sum + ", answer_list : " + answer_list);
        }

        int[] answer = new int[answer_list.size()];
        for (int j=0; j<answer_list.size(); j++) {
            answer[j] = answer_list.get(j);
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
