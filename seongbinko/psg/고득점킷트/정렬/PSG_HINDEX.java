package psg.고득점킷트.정렬;

import java.util.Arrays;

public class PSG_HINDEX {
    public static void main(String[] args) {
        PSG_HINDEX psgHindex = new PSG_HINDEX();
        int solution = psgHindex.solution(new int[]{0, 1, 4, 4, 4});
        System.out.println(solution);

    }

    public int solution(int[] citations) {
        Arrays.sort(citations); // 오름차순 정렬

        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}
