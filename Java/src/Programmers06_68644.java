import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/68644
 */
public class Programmers06_68644 {
    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};

        int[] res = solution(numbers);
        System.out.println(Arrays.toString(res));
    }

    public static int[] solution(int[] numbers) {
        // 중복x, 오름차순 유지
        Set<Integer> set = new TreeSet<>();

        for (int i=0; i<numbers.length; i++) {
            for (int j=0; j<numbers.length; j++) {
                if (i != j) set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        Iterator<Integer> itr = set.iterator();

        int i = 0;
        while (itr.hasNext()) {
            answer[i] = itr.next();
            i++;
        }

        return answer;

        //return set.stream().mapToInt(Integer::intValue).toArray();
    }
}