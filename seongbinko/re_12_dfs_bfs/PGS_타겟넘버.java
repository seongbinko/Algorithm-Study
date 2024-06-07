package re_12_dfs_bfs;

public class PGS_타겟넘버 {
    public static void main(String[] args) {
        PGS_타겟넘버 obj = new PGS_타겟넘버();
        System.out.println(obj.solution(new int[]{1, 1, 1, 1, 1}, 3)); // 5
//        System.out.println(obj.solution(new int[]{4, 1, 2, 1}, 4)); //  2
    }

    static int N;
    static int T;
    static int cnt;
    static int[] numbers;

    // 경우의 수 문제
    // 1. + 한다
    // 2. - 한다
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        T = target;
        this.numbers = numbers;

        dfs(0, 0);

        return cnt;
    }

    private void dfs(int idx, int value) {

        // 종료 조건
        if (idx == N) {
            if (value == T) {
                cnt++;
                return;
            }
            return;
        }

        int number = numbers[idx];
        // + 한다
        dfs(idx + 1, value + number);
        // - 한다.
        dfs(idx + 1, value + number * (-1));

    }

}
