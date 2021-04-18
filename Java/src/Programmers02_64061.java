import java.util.Stack;

public class Programmers02_64061 {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        // 4, 3, 1, 1, 3, 2, 0, 4
        int res = solution(board, moves);
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int col : moves) {
            for (int row = 0; row < board.length; row++) {
                // 스택이 비어있지않고, 집어든 값이 가장 위의 값과 같은경우 삭제
                if (!stack.empty() && (stack.peek() == board[row][col - 1])) {
                    System.out.println(board[row][col - 1]);
                    stack.pop();
                    board[row][col - 1] = 0;
                    answer += 2;
                    break;
                }
                // 값이 0이 아닐 경우 stack으로 가져옴
                else if (board[row][col - 1] != 0) {
                    System.out.println(board[row][col - 1]);
                    stack.push(board[row][col - 1]);
                    board[row][col - 1] = 0;
                    break;
                }

            }
        }
        return answer;
    }
}
