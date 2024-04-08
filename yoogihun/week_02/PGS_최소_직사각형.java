package week_02;

public class PGS_최소_직사각형 {
    public static int main(int[][] sizes) {
        int[] aList = new int[sizes.length];
        int[] bList = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            int a = sizes[i][0]; // 첫 번째 값
            int b = sizes[i][1]; // 두 번째 값

            if (a > b) {
                aList[i] = a;
                bList[i] = b;
            } else {
                aList[i] = b;
                bList[i] = a;
            }
        }

        // aList와 bList에서 최대값 찾기
        int max = aList[0];
        int max2 = bList[0];

        for (int i = 1; i < aList.length; i++) {
            if (aList[i] > max) {
                max = aList[i];
            }
        }

        for (int i = 1; i < bList.length; i++) {
            if (bList[i] > max2) {
                max2 = bList[i];
            }
        }

        return max * max2;
    }
}
