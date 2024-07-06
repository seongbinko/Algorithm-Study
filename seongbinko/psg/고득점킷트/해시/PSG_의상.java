package psg.고득점킷트.해시;

import java.util.HashMap;
import java.util.Map;

public class PSG_의상 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        PSG_의상 psg_의상 = new PSG_의상();
        System.out.println(psg_의상.solution(clothes));
    }

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);

        }
        int result = 1;
        for (String key : map.keySet()) {
            result = result * (map.get(key) + 1);
        }

        return result - 1;
    }
}
