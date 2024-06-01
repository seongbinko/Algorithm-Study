package re_02;

public class PGS_최소직사각형 {

    public static void main(String[] args) {
        int[][] sizes = {
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40}
        };

        System.out.println(solution(sizes));
    }

    private static int solution(int[][] sizes) {
        int maxW = 0;
        int maxY = 0;

        for (int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];

            if (w >= h) {
                maxW = Math.max(maxW, w);
                maxY = Math.max(maxY, h);
            } else {
                maxW = Math.max(maxW, h);
                maxY = Math.max(maxY, w);
            }
        }
        return maxW * maxY;
    }
}
