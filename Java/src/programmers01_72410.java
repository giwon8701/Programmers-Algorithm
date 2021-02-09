import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/72410?language=java
 */
public class programmers01_72410 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ex1 = "...!@BaT#*..y.abcdefghijklm";
        String ex2 = "z-+.^.";
        String ex3 = "=.=";
        String ex4 = "123_.def";
        String ex5 = "abcdefghijklmn.p";
        solution(ex1);
    }
    // 프로그래머스에서는 void가 아닌 String을 반환해줌
    public static void solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        char[] id_arr = new_id.toLowerCase().toCharArray();
        List<Character> id = new LinkedList<>();

        step_one(id_arr, id);
        step_two(id);
        step_three(id);
        step_four(id);
        step_five(id);
        step_six(id);
        step_seven(id, answer);

    }

    // 1단계 (대문자 -> 소문자) 및 ASCII 변환
    private static void step_one(char[] id_arr, List<Character> id) {
        /*--------------------Start----------------------*/
        // 받아온 new_id를 id_arr라는 배열에 문자를 하나하나 넣어줌
        for (char ch : id_arr) {
            id.add(ch);
        }
        /*-----------------------------------------------*/
        System.out.print("1단계: ");
        for (Character ch : id) {
            System.out.print(ch);
        }
        System.out.println();
    }
    // 2단계 (소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거)
    private static void step_two(List<Character> id) {
        /*--------------------Start----------------------*/
        for (int i = 0; i < id.size(); i++) {
            if (((id.get(i) < '0' || id.get(i) > '9') &&                   // 숫자가 아닐 때
                    (id.get(i) < 'a' || id.get(i) > 'z')) &&                     // 알파벳이 아닐 때
                    (id.get(i) != '-' && id.get(i) != '_' && id.get(i) != '.')) {  // 빼기, 밑줄, 마침표 가 아닐 때
                id.remove(i);
                i = 0;
            }
        }
        /*-----------------------------------------------*/
        System.out.print("2단계: ");
        for (Character ch : id) {
            System.out.print(ch);
        }
        System.out.println();
    }
    // 3단계 (해당문자와 다음문자가 마침표일 때 현재문자 삭제)
    private static void step_three(List<Character> id) {
        /*--------------------Start----------------------*/
        int cnt = 0;
        while (!id.isEmpty()) {
            if ((cnt != id.size() - 1) && id.get(cnt).equals('.') && id.get(cnt).equals(id.get(cnt + 1))) {   // Integer는 객체이므로 .equals()로 비교해야한다.
                id.remove(cnt);
                cnt = 0;
            } else {
                cnt++;
            }
            if (cnt == id.size()) break;
        }
        /*-----------------------------------------------*/
        System.out.print("3단계: ");
        for (Character ch : id) {
            System.out.print(ch);
        }
        System.out.println();
    }
    // 4단계 (첫 혹은 마지막 인덱스가 마침표일 때)
    private static void step_four(List<Character> id) {
        /*--------------------Start----------------------*/
        // 첫 인덱스가 마침표일 때 (size가 1이면 여기서 지워줌으로써 size=0이 됨)
        if (id.get(0).equals('.')) {
            id.remove(0);
        }
        // 마지막 인덱스가 마침표일 때
        // (바로 위에서 지워버려서 size가 0이면 지울것이 없기 때문에 size가 0인경우는 제외)
        if (id.size() != 0 && id.get(id.size() - 1).equals('.')) {
            id.remove(id.size() - 1);
        }
        /*-----------------------------------------------*/
        System.out.print("4단계: ");
        for (Character ch : id) {
            System.out.print(ch);
        }
        System.out.println();
    }
    // 5단계 (빈 문자열일 때, a 대입)
    private static void step_five(List<Character> id) {
        /*--------------------Start----------------------*/
        if (id.size() == 0) {
            id.add('a');
        }
        /*-----------------------------------------------*/
        System.out.print("5단계: ");
        for (Character ch : id) {
            System.out.print(ch);
        }
        System.out.println();
    }
    // 6단계 (new_id길이가 16이상일 때 그 뒤의 문자들 삭제)
    private static void step_six(List<Character> id) {
        /*--------------------Start----------------------*/
        if (id.size() >= 16) {
            // 15부터 size()-1까지 자른다음 삭제
            id.subList(15, id.size()).clear();
            // 끝 인덱스가 .일 경우 삭제
            if (id.get(14).equals('.')) id.remove(14);
        }
        /*-----------------------------------------------*/
        System.out.print("6단계: ");
        for (Character ch : id) {
            System.out.print(ch);
        }
        System.out.println();
    }
    // 7단계 (길이가 2자 이하라면 마지막 문자 똑같이 추가해줌)
    private static void step_seven(List<Character> id, StringBuilder answer) {
        /*--------------------Start----------------------*/
        if (id.size() <= 2) {
            while (id.size() != 3) {
                id.add(id.get(id.size() - 1));
            }
        }
        /*-----------------------------------------------*/
        System.out.print("7단계: ");
        for (char i : id) {
            System.out.print(i);
            answer.append(i);
        }
        System.out.println();
    }

}
