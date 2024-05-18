package week_02;

import java.util.Arrays;
import java.util.Scanner;

public class PGS_k진수에서_소수_개수_구하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String val = "";
        if (k == 2) {
            val = Long.toBinaryString(n);
        } else {
            val = Long.toString(n,k);
        }
        String[] numList = val.split("0");
        long anwser = Arrays.stream(val.split("0"))
                .filter(v -> !v.equals("1") && !v.equals("") && isPrime(Long.parseLong(v)))
                .count();
        System.out.println(anwser);
    }

    private static boolean isPrime(Long number) {
        if(number == 1){
            return false;
        }

        //해당 수의 제곱근까지
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
