package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1463_1로만들기 {

    static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        recur(0, n);
        System.out.println(minCount);
    }

    private static void recur(int count, int n) {


        //n이 1인 경우, 종료
        if(n == 1){
            minCount = Math.min(count, minCount);
            return;
        }

        //n이 3으로 나뉘는 경우
        if(n % 3 == 0){
            recur(count+1, n/3);
        }

        //n이 2로 나뉘는 경우
        if(n % 2 == 0){
            recur(count+1, n/2);
        }

        //n을 1로 뺴는 경우
        recur(count+1, n-1);

    }



    /*
        - N이 3으로 나누어 떨어지면, 3으로 나눈 결과 저장, 아니라면 통과
        - N이 2로 나누어 떨어지면, 2으로 나눈 결과 저장, 아니라면 통과
        - 1을 뺀 결과 저장

        N=10
        | N/3 | N/2 | N-1 |
        | 패스 | 5   | 9   |
        => 연산 1번째, 결과 5, 9

        N=5
        | N/3 | N/2 | N-1 |
        | 페스 | 패스 | 4   |

        N=9
        | N/3 | N/2 | N-1 |
        | 3   | 패스 | 8   |
        => 연산 2번째, 결과 4, 3, 8

        N=4
        | N/3 | N/2 | N-1 |
        | 패스 | 2   | 3   |

        N=3
        | N/3 | N/2 | N-1 |
        | 1   |     |     |
        => 연산 3번쨰, 결과 1! 종료

        연산횟수에 대한 결과개수가 다양하게 나올 수 있을 것 같다.
        재귀로 연산 결과마다 3가지 연산을 비교하는게 좋을 것 같다.

        * */

}