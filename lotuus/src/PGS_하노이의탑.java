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

    public static int[][] solution(int n) {
        int[][] answer = {};

        //하노이의 탑 세개의 기둥 1, 2, 3번
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

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

        //3번에 다 채워지면 종료
        while(stack3.size() != n){

            if(stack3.size() == n){
                break;
            }

            boolean moveFirstToSecond = stack2.empty() || (stack1.peek() < stack2.peek());
            if(moveFirstToSecond){
                moved.add(new int[]{1, 2});
                stack2.push(stack1.pop());
                continue;
            }

            boolean moveFirstToThree = stack3.empty() || (stack1.peek() < stack3.peek());
            if(moveFirstToThree){
                moved.add(new int[]{1, 3});
                stack3.push(stack1.pop());
                continue;
            }

            boolean moveSecondToFirst = stack1.empty() || (stack2.peek() < stack1.peek());
            if(moveSecondToFirst){
                moved.add(new int[]{1, 3});
                stack1.
                continue;
            }

            boolean moveSecondToThird = stack3.empty() || (stack2.peek() < stack3.peek());
            if(moveSecondToThird){
                moved.add(new int[]{1, 3});
                continue;
            }
        }

        recursion();



        //N개의 원판을 3번 원판으로 최소로 옮기는 방법 return
        return answer;
    }

    private static void recursion() {

        //

    }


}
