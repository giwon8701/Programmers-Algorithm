import java.util.Arrays;

public class tes {
    public static void main(String[] args) {
        int[][] progresses = {
                {93, 30, 55},
                {95, 90, 99, 99, 80, 99}
        };
        int[][] speeds = {
                {1, 30 ,5},
                {1, 1, 1, 1, 1, 1}
        };

        solution(progresses[0], speeds[0]);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }

        System.out.println(Arrays.toString(dayOfend));
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}