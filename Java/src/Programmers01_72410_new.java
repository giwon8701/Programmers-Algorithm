import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// id를 String에 담아서 풀어보기
// 정규식 이용하여 풀어보기
public class Programmers01_72410_new {
    public static void main(String[] args) {
        List<Character> id = new ArrayList<>();

        id.add('a');
        id.add('b');
        id.add('c');
        id.add('d');
        id.add('e');
        id.add('f');
        id.add('g');
        id.add('h');
        id.add('i');
    }


    public static String solution(String new_id) {
        String answer = "";

        new_id = new_id.toLowerCase()
                        // 2단계 (소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거)
                       .replaceAll("[^a-z0-9-_.]", "")
                        // 3단계 (마침표가 연속으로 중복될 때)
                       .replaceAll("[.]{2,}", ".");
                        // 4단계 (첫 혹은 마지막 인덱스가 마침표일 때)



        return answer;
    }
}
