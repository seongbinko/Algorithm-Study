package week_00;

import java.io.*;
import java.util.*;

public class BOJ_1000_두_수의_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int num1 = nums[0];
        int num2 = nums[1];
        System.out.println(num1 + num2);
    }
}
