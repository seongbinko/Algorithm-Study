package psg.고득점킷트.스택큐;

import java.util.ArrayDeque;
import java.util.Deque;

public class PSG_올바른괄호 {
    /*
    "()()"	true
    "(())()"	true
    ")()("	false
    "(()("	false
     */
    public static void main(String[] args) {
        PSG_올바른괄호 psg_올바른괄호 = new PSG_올바른괄호();
        boolean solution = psg_올바른괄호.solution("(())()");
        System.out.println(solution);

    }

    boolean solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (deque.isEmpty()) {
                deque.offer(s.charAt(i));
            } else {
                if (matches(deque.peekLast(), s.charAt(i))) {
                    deque.pollLast();
                } else {
                    deque.offer(s.charAt(i));
                }
            }
        }
        return deque.isEmpty();
    }

    static boolean matches(char ch1, char ch2) {
        if (ch1 == '(' && ch2 == ')') {
            return true;
        }
        return false;
    }
}
