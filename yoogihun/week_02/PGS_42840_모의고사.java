package week_02;

import java.util.*;
import java.util.stream.IntStream;

public class PGS_42840_모의고사 {
    public int[] main(int[] answers) {
        //시험은 최대 10000문제 까지 있음
        //정답이 순서대로 들어있는 배열이 있음
        //1,2,3,4,5
        //2,1,2,3,2,4,2,5
        //3,3,1,1,2,2,4,4,5,5
        // 각 수포자들의 정답 리스트
        List<Integer> oneList = List.of(1, 2, 3, 4, 5);
        List<Integer> twoList = List.of(2, 1, 2, 3, 2, 4, 2, 5);
        List<Integer> threeList = List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);

        // 각 수포자들이 맞춘 문제 수 계산
        int one = (int) IntStream.range(0, answers.length)
                .filter(i -> answers[i] == oneList.get(i % oneList.size()))
                .count();

        int two = (int) IntStream.range(0, answers.length)
                .filter(i -> answers[i] == twoList.get(i % twoList.size()))
                .count();

        int three = (int) IntStream.range(0, answers.length)
                .filter(i -> answers[i] == threeList.get(i % threeList.size()))
                .count();

        // 가장 많은 문제를 맞힌 사람의 점수 찾기
        int maxScore = Math.max(one, Math.max(two, three));

        // 가장 많은 문제를 맞힌 사람의 번호 배열로 반환
        List<Integer> resultList = new ArrayList<>();
        if (maxScore == one) resultList.add(1);
        if (maxScore == two) resultList.add(2);
        if (maxScore == three) resultList.add(3);

        return resultList.stream().mapToInt(i -> i).toArray();
    }
}
