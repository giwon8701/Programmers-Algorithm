import java.util.ArrayList;
import java.util.List;

public class Kakao_Q2 {
    public static void main(String[] args) {
        // |x1-x2| + |y1-y2| > 2 or 파티션으로 막혀있어야함
        String[][] places = {
                {"POOOP",
                 "OXXOX",
                 "OPXPX",
                 "OOXOX",
                 "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        solution(places);
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        char[][] place = new char[5][5];
        for (int i = 0; i < 5; i++) {
            List<int[]> people = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                place[j] = places[i][j].toCharArray();
                System.out.print(j+" : ");
                System.out.println(place[j]);

                for (int k=0; k < 5; k++) {
                    if (place[j][k] == 'P') people.add(new int[]{j, k});
                }

            }


        }


        return answer;
    }
}
