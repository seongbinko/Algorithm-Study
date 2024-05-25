package week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PGS_하노이의탑 {
    public static void main(String[] args) {
        //만약 3개가 존재한다.
        //1,2 1,2 1,3 2,3 2,3
        //만약 5개가 존재한다.
        //1,2 * n-1,1,3,2,3 * n-1
        //1,2 1,2 1,2 1,2 1,3 2,3 2,3 2,3 2,3
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 2,1,2
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            List<Integer> a = new ArrayList<>();
            a.add(1);
            a.add(2);
            result.add(a);
        }
        result.add(List.of(1,3));

        for (int j = 0; j < n - 1; j++) {
            List<Integer> a = new ArrayList<>();
            a.add(2);
            a.add(3);
            result.add(a);
        }
        System.out.println(result);
    }
}
