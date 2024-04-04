package week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 조건
 * N 은 100이하 자연수
 * 1~9로만 이루어진 3자리 수
 *
 * 4
 * 123 1 1
 * 356 1 0
 * 327 2 0
 * 489 0 1
 *
 * 2
 */
public class BOJ_2503_숫자야구 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<int[]> testCases = new ArrayList<>();

        for (int n = 0; n < N; n++) {
            int[] input = Arrays.stream(String.valueOf(br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
            testCases.add(input);
        }

        int answer = 0;
        // 숫자 i j k 로 나눠서 생각
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    // 세자리 수가 같은 경우라면 건너 뛰기
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    boolean[] booleans = new boolean[N];
                    for (int l = 0; l < N; l++) {
                        int[] input = testCases.get(l); // [123,1,0]

                        int[] nums = Arrays.stream(String.valueOf(input[0]).split("")).mapToInt(Integer::parseInt).toArray();
                        int expectStrike = input[1];
                        int expectBall = input[2];

                        int strikeCnt = 0;
                        int ballCnt = 0;
                        if (i == nums[0]) {
                            strikeCnt ++;
                        } else if (i == nums[1] || i == nums[2]) {
                            ballCnt++;
                        }
                        if (j == nums[1]) {
                            strikeCnt ++;
                        } else if (j == nums[0] || j == nums[2]) {
                            ballCnt++;
                        }
                        if (k == nums[2]) {
                            strikeCnt ++;
                        } else if (k == nums[0] || k == nums[1]) {
                            ballCnt++;
                        }
                        if (strikeCnt == expectStrike && ballCnt == expectBall) {
                            booleans[l] = true;
                        }
                        // 모든 스트라이크 볼카운트가 충족될때 cnt+1
                    }
                    if (allTrue(booleans)) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean allTrue(boolean[] arr) {
        for (boolean b : arr) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
