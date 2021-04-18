import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/42587
프린터
 */

public class Programmers04_42587 {
    public static void main(String[] args) {

        int[][] priorites = {
                {2, 1, 3, 2, 4, 6, 4, 7},
                {1, 1, 9, 1, 1, 1}
        };
        int[] location = {2, 0};

        int i = 0;
        System.out.println(solution(priorites[i], location[i]));
    }

    public static int solution(int[] priorities, int location) {
        // location의 앞에 아무것도 없으면 첫번째로 출력(1)
        int answer = 0;
        List<int[]> list = new ArrayList<>();

        // list에 (위치, 값)의 형식으로 넣어줌
        for(int i=0; i<priorities.length; i++) {
            int[] arr = {i, priorities[i]};
            list.add(arr);
        }

        // 첫번째와 다른 인덱스와 비교했을때 첫번쨰가 작으면 맨 뒤로보냄
        for(int i=0; i<priorities.length; i++) {
            for (int j=i+1; j<priorities.length; j++) {
                if (list.get(i)[1] < list.get(j)[1]) {
                    list.add(list.get(i));
                    list.remove(i);
                    j = i;  // for문에 의해서 j = i+1부터 시작

                    System.out.print("[ ");
                    for (int[] a: list) {
                        System.out.print(a[1]+" ");
                    }
                    System.out.println("]");
                }
            }
        }

        // list의 위치가 locaion변수와 같다면 answer+1해줌
        for(int i=0; i<priorities.length; i++) {
            System.out.print(list.get(i)[0]+" ");
            if (list.get(i)[0] == location) {
                answer = i+1;
            }
        }
        System.out.println();

        return answer;
    }
}
