import java.util.ArrayList;
import java.util.List;

public class level2_타겟_넘버 {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;


        solution(numbers, target);
    }

    public static int solution(int[] numbers, int target) {
        List<Integer> ans_list = new ArrayList<>();
        ans_list.add(0);

        return cal_result(numbers, target, 0, ans_list);
    }

    public static int cal_result(int[] numbers, int target, int idx, List<Integer> ans_list) {
        List<Integer> imsi = ans_list;

        for (int i : imsi) {    // imsi 리스트에 현재인덱스의 수를 더하거나 빼준 값을 추가
            imsi.add(i+numbers[idx]);
            imsi.add(i-numbers[idx]);
        }

        idx++;  // 다음 인덱스로 넘어감
        if (idx == numbers.length) {
            int answer = 0;
            for (int i: imsi) {

            }
        }

        return (idx == numbers.length) ? answer : ;
    }
}
