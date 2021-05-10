import java.util.HashMap;
import java.util.Map;

public class Kakao_Q1 {

    public static void main(String[] args) {
        String[] s = {"one4seveneight", "23four5six7", "2three45sixseven", "123"};

        for (String v : s) {
            System.out.println(solution(v));
        }
    }

    public static int solution(String s) {
        String answer = s;

        final Map<String, String> num_eng = new HashMap<>() {{
            put("zero", "0");
            put("one", "1");
            put("two", "2");
            put("three", "3");
            put("four", "4");
            put("five", "5");
            put("six", "6");
            put("seven", "7");
            put("eight", "8");
            put("nine", "9");
        }};

        for (String key : num_eng.keySet()) {
            answer = answer.replace(key, num_eng.get(key));
        }

        return Integer.parseInt(answer);
    }
}
