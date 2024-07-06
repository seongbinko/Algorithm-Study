package psg.고득점킷트.해시;

import java.util.HashMap;
import java.util.Map;

public class PSG_완주하지못한선수 {

    public static void main(String[] args) {
        PSG_완주하지못한선수 psg_완주하지못한선수 = new PSG_완주하지못한선수();
        String solution = psg_완주하지못한선수.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
        System.out.println(solution);

    }

    // 선수 이름을 key로 map을 구성하며, 그곳에 숫자를 기록, 만약 0보다 큰 값이라면 그 사람은 완주하지 못한 것
    // 완주하지 못한 선수는 단 한 명
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String pa : participant) {
            map.put(pa, map.getOrDefault(pa, 0) + 1);
        }
        for (String co : completion) {
            map.put(co, map.getOrDefault(co, 0) - 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return key;
            }
        }
        return "";
    }
}
