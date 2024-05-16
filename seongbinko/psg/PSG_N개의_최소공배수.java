package psg;

public class PSG_N개의_최소공배수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 6, 8, 14}));
    }

    public static int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            answer = (answer * arr[i]) / gcd(answer, arr[i]);
        }
        return answer;
    }

    private static int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
