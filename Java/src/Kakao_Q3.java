import java.util.*;

public class Kakao_Q3 {
    public static void main(String[] args) {
        int[] n = {8, 8};
        int[] k = {2, 2};
        String[][] cmd = {
                {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"},
                {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}
        };
        String[] result = {"OOOOXOOO", "OOXOXOOO"};


        for (int i=0; i<n.length; i++) {
            System.out.println(solution(n[i], k[i], cmd[i]));
        }
    }

    public static String solution(int n, int k, String[] cmd) {
        char[] answer = new char[n];
        int cursor = k;
        Stack<String> backup_name = new Stack<>();
        List<String> origin_name = new ArrayList<>();
        List<String> name = new ArrayList<>(origin_name);
        Map<String, Integer> map = new HashMap<>(); // 이름의 원래 위치
        for (int i=0; i<n; i++) {
            origin_name.add(String.valueOf(i));
            name.add(origin_name.get(i));
            map.put(String.valueOf(i), i);
        }

        for (String command : cmd) {

            if (command.equals("C")) {  // 삭제 커맨드일 경우
                // 백업에 삭제할 이름 저장
                backup_name.push(name.get(cursor));
                name.remove(cursor);
                if (cursor == name.size()) cursor--;

            } else if (command.equals("Z")) {   // 복구 커맨드일 경우
                // 백업할 이름위치가 행 안에 있을 경우
                if (map.get(backup_name.peek()) < name.size()-1) {
                    // 백업위치가 커서보다 앞에 있을경우 커서+1
                    if (cursor >= map.get(backup_name.peek())){
                        cursor++;
                    }
                    name.add(map.get(backup_name.peek()), backup_name.pop());
                // 커서가 행 밖에 있을경우
                } else if ( map.get(backup_name.peek()) > map.get(name.get(name.size()-1)) ) {
                    name.add(backup_name.pop());
                }

            } else {    // U or D일때 커서이동 기능
                cursor += (command.charAt(0) == 'U') ? -(command.charAt(2)-'0') : (command.charAt(2)-'0');
            }
        }

        for (int i=0; i<n; i++) {
            answer[i] = (name.contains(origin_name.get(i))) ? 'O' : 'X';
        }


        return String.valueOf(answer);
    }


}
