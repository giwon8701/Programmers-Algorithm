/*
https://programmers.co.kr/learn/courses/30/lessons/12912
 */
public class Programmers07_12912 {
    public static void main(String[] args) {

        System.out.println(solution(3, 5));
    }

    public static long solution(int a, int b) {
        long answer = 0;
        for (int i = Math.min(a,b); i <= Math.max(a,b); i++) {
            answer += i;
        }

        return answer;
        // 내가 쓴 코드가 효율이 훨씬 좋음 ㅎㅎ
        //return sumAtoB(Math.min(a,b), Math.max(a,b));
    }
/*
    private static long sumAtoB(long a, long b) {
        return (b-a+1) * (a+b) / 2;
        // 등차수열의 합 : Sum = (n * (a+b)) / 2
        // n = a부터 b까지의 갯수(=a-b+1)
    }
*/
}
