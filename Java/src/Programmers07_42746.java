import java.util.*;
import java.util.stream.Collectors;

public class Programmers07_42746 {
    public static void main(String[] args) {
        int[][] numbers = {
            {6, 10, 2},
            {3, 30, 34, 5, 9}
        };

        int i = 0;
        solution(numbers[i]);
    }

    public static String solution(int[] numbers) {

        // boxed() => 원시타입을 참조타입으로 변환해줌
        // collect => 해당 컬렉션으로 바꿔줌
        List<Integer> numbers_list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        Set<String> answer = new HashSet<>();

        for (int i=0; i<numbers.length; i++) {
            StringBuilder sum = new StringBuilder();

            sum.append(numbers_list.get(i));
            for (int j = 0; j < numbers.length; j++) {
                if (j != i) {
                    sum.append(numbers_list.get(j));
                }
            }

            answer.add(sum.toString());
        }

        int max = 0;
        for (String s: answer) {
            System.out.println(s);
            max = Math.max(max, Integer.parseInt(s));
        }

        return String.valueOf(max);
    }
}
