import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PGS_하노이의탑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(
                Arrays.deepToString(
                        solution(Integer.parseInt(st.nextToken()))
                )
        );
    }

    //하노이의 탑 세개의 기둥 1, 2, 3번
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    static Stack<Integer> stack3 = new Stack<>();
    static int N;

    public static int[][] solution(int n) {
        int[][] answer = {};

        n = N;

        //1번째 기둥에 N개의 원판 입력
        //원판의 크기 입력
        for (int i = n; 0 < i; i--) {
            stack1.push(i);
        }

        //원판 옮기기
        //한 번에 하나의 원판만 옮길 수 있습니다.
        //큰 원판이 작은 원판 위에 있어서는 안됩니다.

        //모든 경우의 수
        //1 -> 2, 3 이동
        //2 -> 1, 3 이동
        //3 -> 1, 2 이동

        //이동 경로 기록하기
        List<int[]> moved = new ArrayList<>();

        recursion(stack1.peek());


        //N개의 원판을 3번 원판으로 최소로 옮기는 방법 return
        return answer;
    }

    private static void recursion(int weight) {

        //종료
        if(stack3.size()== N){
            return;
        }

        //첫번째 기둥에 넣을 수 있는 경우


        //두번쨰 기둥에 넣는 경우
        if(stack2.empty() || weight < stack2.peek()){
            stack2.push(stack1.pop());

            recursion(stack1.peek());
        }


        //세번째 기둥에 넣을 수 있는 경우
        if(stack3.empty() || weight < stack3.peek()){
            stack3.push(stack1.pop());

            if(!stack1.empty()){
                recursion(stack1.peek());
            }
            if(!stack2.empty()){
                recursion(stack2.peek());
            }

        }


        //각 경우의 수 중 가장 작은거


    }


}
