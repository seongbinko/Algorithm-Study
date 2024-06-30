package psg.고득점킷트.해시;

import java.util.HashSet;
import java.util.Set;

public class PSG_폰켓몬 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 1, 2, 3};
        int[] nums2 = new int[]{3, 3, 3, 2, 2, 4};
        int[] nums3 = new int[]{3, 3, 3, 2, 2, 2};

        PSG_폰켓몬 p = new PSG_폰켓몬();
        int answer = p.solution(nums3);
        System.out.println(answer);
    }

    public int solution(int[] nums) {

        int max = nums.length / 2; // 가져갈 수 있는 최대 폰켓몬

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        return Math.min(set.size(), max);
    }
}
