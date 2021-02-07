import java.util.Arrays;

public class programmers02_12906 {
    public static void main(String[] args) {
        int[] arr_01 = {1, 1, 3, 3, 0, 1, 1};
        int[] arr_02 = {4, 4, 4, 3, 3};

        int[] res_01 = solution(arr_01);
        int[] res_02 = solution(arr_02);
        System.out.println(Arrays.toString(res_01));
        System.out.println(Arrays.toString(res_02));
    }

    public static int[] solution(int[] arr) {
        String temp = "";
        String res = "";
        for (int i : arr) {
            temp += String.valueOf(i);
        }

        // 중복 제거
        for (int i = 0; i < temp.length(); i++) {
            if ((i != temp.length() - 1) && (temp.charAt(i) != temp.charAt(i + 1))) {
                res += temp.charAt(i);
            } else if (i == temp.length() - 1) {
                res += temp.charAt(i);
            }
        }

        int[] answer = new int[res.length()];

        for (int i=0; i<res.length(); i++) {
            answer[i] = Character.getNumericValue(res.charAt(i));
        }

        return answer;
    }

}
