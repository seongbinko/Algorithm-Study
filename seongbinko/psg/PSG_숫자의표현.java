package psg;

public class PSG_숫자의표현 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            if (i == n) {
                answer++;
                break;
            }
            // 합이 n이되면 break;
            int sum = i;
            for (int j = i + 1; j < n + 1; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                }
                // 엣지 케이스
                if (sum > n) {
                    break;
                }
            }
        }
        return answer;
    }
}
