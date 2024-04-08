package week_02;

import java.util.*;

public class PGS_최소직사각형 {

    public static void main(String[] args) {
        int[][] array = {
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40}
        };
        int[][] array2 = {
                {10, 7},
                {12, 3},
                {8, 15},
                {14, 7},
                {5, 15}
        };
        int[][] array3 = {
                {14, 4},
                {19, 6},
                {6, 16},
                {18, 7},
                {7, 11}
        };

        System.out.print(solution(array));
    }

    public static int solution(int[][] sizes) {
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        for (int i = 0; i < sizes.length; i++) {
            int x = sizes[i][0];
            int y = sizes[i][1];

            if (x >= y) {
                xList.add(x);
                yList.add(y);
            } else {
                xList.add(y);
                yList.add(x);
            }
        }
        return Collections.max(xList) * Collections.max(yList);
    }
}
