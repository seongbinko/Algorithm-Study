package re_02;

public class BOJ_2436_공약수_2트 {

    public static void main(String[] args) {
        System.out.println(_gcd(42, 2184));
        System.out.println(_lcm(4, 14));
    }

    private static int _gcd(int a, int b) {
        // a > b
        if (a % b == 0) {
            return b;
        }
        return _gcd(b, a % b);
    }

    private static int _lcm(int a, int b) {
        return a * b / _gcd(a, b);
    }
}
