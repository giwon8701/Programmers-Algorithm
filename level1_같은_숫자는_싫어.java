import java.util.Arrays;
/*
https://programmers.co.kr/learn/courses/30/lessons/12906?language=java
 */
public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        int[] arr_01 = {1, 1, 3, 3, 0, 1, 1};
        int[] arr_02 = {4, 4, 4, 3, 3};

        int[] res_01 = solution(arr_01);
        int[] res_02 = solution(arr_02);
        System.out.println(Arrays.toString(res_01));
        System.out.println(Arrays.toString(res_02));
    }

    public static int[] solution(int[] arr) {
        // String -> StringBuilder로 바꾸니 효율성 테스트 통과
        StringBuilder res = new StringBuilder();    // 필터링한 결과값을 담을 String변수

        // 중복 제거
        for (int i = 0; i < arr.length; i++) {
            if ((i != arr.length - 1) && (arr[i] != arr[i + 1])) {
                res.append(arr[i]);
            } else if (i == arr.length - 1) {
                res.append(arr[i]);
            }
        }

        int[] answer = new int[res.length()];

        for (int i=0; i<res.length(); i++) {
            answer[i] = Character.getNumericValue(res.charAt(i));
        }

        return answer;
    }

}
