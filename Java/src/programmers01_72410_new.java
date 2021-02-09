import java.util.ArrayList;
import java.util.List;

// id를 String에 담아서 풀어보기
// 정규식 이용하여 풀어보기
public class programmers01_72410_new {
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

        List<Character> id_new = new ArrayList<>();
        id_new = id.subList(5,id.size());
        id_new.set(id_new.size()-1, 'z');
        System.out.println(id);
    }
}
