import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.*;
import java.util.stream.Collectors;

/*
https://programmers.co.kr/learn/courses/30/lessons/42587
 */

public class Programmers08_42587 {
    public static void main(String[] args) {

        int[][] priorites = {
                {2, 1, 3, 2},
                {1, 1, 9, 1, 1, 1}
        };
        int[] location = {2, 0};

        int i = 1;
        System.out.println(solution(priorites[i], location[i]));
    }

    public static int solution(int[] priorities, int location) {
        // location의 앞에 아무것도 없으면 첫번째로 출력(1)
        int answer = location + 1;

        Queue<int[]> queue = new LinkedList<>();

        for (int i=0; i<priorities.length; i++) {
            int[] arr = {i, priorities[i]};
            queue.add(arr);
        }

        for (int[] i: queue) {
            if ((queue.peek() != null) && (queue.peek()[1] == i[1])) {
                queue.add();
            }
        }




        return answer;
    }
}
