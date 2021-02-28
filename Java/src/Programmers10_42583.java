import java.util.LinkedList;
import java.util.Queue;
/*
https://programmers.co.kr/learn/courses/30/lessons/42583
코드 너무 더럽게 짰다....
 */
public class Programmers10_42583 {
    public static void main(String[] args) {
        int[] bridge_length = {2, 100, 100};
        int[] weight = {10, 100, 100};
        int[][] truck_weights = {
            {7, 4, 5, 6},
            {10},
            {10, 10, 10, 10, 10, 10, 10 ,10, 10, 10}
        };

        int i = 2;
        System.out.println("answer : " + solution(bridge_length[i], weight[i], truck_weights[i]));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        // 넘어가야 할 트럭의 갯수
        Queue<Integer> start = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> end = new LinkedList<>();
        int bridge_weight = 0;

        for(int truck: truck_weights) {
            start.add(truck);
        }
        for (int i=0; i<bridge_length; i++) {
            bridge.add(0);
        }

        while(end.size() != truck_weights.length) {

            if (!start.isEmpty()) {
                // 다음 트럭이 들어와도 무게가 충분하면
                if (bridge_weight + start.peek() <= weight) {
                    // 다리 진입함
                    bridge_weight += start.peek();
                    bridge.add(start.poll());

                    // 다리 건넜음
                    if (bridge.peek() == 0) {
                        bridge.poll();
                    } else {
                        bridge_weight -= bridge.peek();
                        end.add(bridge.poll());
                    }
                // 무게초과 직전이라 트럭이 들어올 수 없으면
                } else if (bridge_weight + start.peek() > weight) {
                    // peek에 트럭이 있으면 다리를 건너게 하고
                    if (!bridge.isEmpty() && bridge.peek() != 0) {
                        bridge_weight -= bridge.peek();
                        end.add(bridge.poll());
                        // 새로운 트럭이 진입해도 괜찮으면 진입
                        if (bridge_weight + start.peek() <= weight) {
                            bridge_weight += start.peek();
                            bridge.add(start.poll());
                        // 진입하면 무게초과라면 다리의 트럭만 한칸 이동
                        } else {
                            bridge.add(0);
                        }
                    // peek에 트럭이 없으면(=0이 있으면) 무게초과를 해결할 수 없으므로 한칸이동만 함
                    } else {
                        bridge.poll();
                        bridge.add(0);
                    }

                }
            // start가 비어있고
            } else {
                // bridge에 아직도 트럭이 남아있을 때
                if (bridge_weight > 0) {
                    // 다리 끝에 트럭이 없으면 한칸 이동
                    if (!bridge.isEmpty() && bridge.peek() == 0) {
                        bridge.poll();
                    // 다리 끝에 트럭이 있으면 다리에서 벗어남
                    } else if (!bridge.isEmpty() && bridge.peek() != 0){
                        bridge_weight -= bridge.peek();
                        end.add(bridge.poll());
                    }
                // bridge에 트럭이 더 이상 없다면
                } else {
                    break;
                }

            }
            answer++;
        }

        answer--;


        return answer;
    }
}
