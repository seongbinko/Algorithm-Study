package psg;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PSG_올바른괄호 {
    public static void main(String[] args) {
        PSG_올바른괄호 method = new PSG_올바른괄호();

        String s = "({{})";
        System.out.println(method.solution2(s));
    }

    boolean solution(String s) {
        char[] chs = s.toCharArray();
        Deque<Character> q = new ArrayDeque<>();
        for (char c : chs) {
            q.offer(c);
        }
        Deque<Character> st = new ArrayDeque<>();
        st.offerLast(q.pollFirst());
        while (!q.isEmpty()) {
            Character ch = q.pollFirst();
            if (ch != null) {
                if (st.isEmpty()) {
                    st.offerLast(ch);
                    continue;
                }
                if (isValid(ch, st.peekLast())) {
                    st.pollLast();
                } else {
                    st.offerLast(ch);
                }
            }
        }

        return st.isEmpty();
    }

    boolean solution2(String s) {
        char[] chs = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < chs.length; i++) {
            if (i == 0 || st.isEmpty() || !isValid(chs[i], st.peek())) {
                st.push(chs[i]);
                continue;
            }
            st.pop();
        }
        return st.isEmpty();
    }


    public static boolean isValid(char actual, char target) {
        return switch (actual) {
            case '}' -> target == '{';
            case ')' -> target == '(';
            case ']' -> target == ']';
            default -> false;
        };
    }
}
