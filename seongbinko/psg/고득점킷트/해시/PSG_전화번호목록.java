package psg.고득점킷트.해시;

import java.util.HashMap;
import java.util.Map;

/*
["119", "97674223", "1195524421"]	false
["123","456","789"]	true
["12","123","1235","567","88"]	false
 */
public class PSG_전화번호목록 {
    public static void main(String[] args) {
        PSG_전화번호목록 psg_전화번호목록 = new PSG_전화번호목록();
        boolean solution = psg_전화번호목록.solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println(solution);

    }

    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        // 모든 phone 번호 hashMap에 담기
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            // 전화번호의 길이만큼 순회
            for (int j = 0; j < phone_book[i].length(); j++) {
                // 해당 전화번호의 접두어가 key로 가진 경우
                String substring = phone_book[i].substring(0, j);
                // 119 -> 1195524421을 찾는 것이 아님
                // 1195524421 -> 119를 찾아서 접두어인지를 판단함
                if (map.containsKey(substring)) {
                    return false;
                }
            }
        }

        return true;
    }
}
