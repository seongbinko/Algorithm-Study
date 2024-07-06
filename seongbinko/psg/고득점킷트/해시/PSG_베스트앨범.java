package psg.고득점킷트.해시;

import java.util.*;

public class PSG_베스트앨범 {
    public static void main(String[] args) {
        PSG_베스트앨범 psg_베스트앨범 = new PSG_베스트앨범();
        int[] solution = psg_베스트앨범.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(String[] genres, int[] plays) {
        // 장르별 플레이 횟수를 구할 map
        Map<String, Integer> sumMap = new HashMap<>();
        // 장르별로 고유번호 플레이 타임을 기록할 곳
        Map<String, List<int[]>> map = new HashMap<>();
        // 정답을 담을 곳
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            sumMap.put(genre, sumMap.getOrDefault(genre, 0) + play);

            List<int[]> arr = map.getOrDefault(genre, new ArrayList<>());
            arr.add(new int[]{i, play});
            map.put(genre, arr);
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(sumMap.entrySet());
        // 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        entries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // 장르는 100개 미만이기에 2중 반복문도 괜찮음
        for (Map.Entry<String, Integer> entry : entries) {
            List<int[]> arr = map.get(entry.getKey());
            // 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
            // 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
            arr.sort((e1, e2) -> e2[1] - e1[1] == 0 ? e1[0] - e2[0] : e2[1] - e1[1]);

            int length = arr.size() > 1 ? 2 : 1;
            for (int i = 0; i < length; i++) {
                resultList.add(arr.get(i)[0]);
            }
        }

        return resultList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
