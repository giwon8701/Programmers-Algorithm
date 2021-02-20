import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
        int cnt = location;

        // collect() : 원하는 자료형으로 변환해줌
        // boxed() : 원시타입을 참조타입으로 바꿔줌
        // mapToInt(Integer::intValue) : 참조타입을 원시타입으로 바꿔줌
        List<Integer> list = Arrays.stream(priorities).boxed().collect(Collectors.toList());

        int i = 0;
        while(i < priorities.length) {
            if (list.get(i) <= list.get(i+1)) {
                list.add(list.get(i));
                list.remove(i);
                i--;
            }
            i++;
        }


        return answer;
    }
}
