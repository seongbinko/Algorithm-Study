package psg.고득점킷트.정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PSG_가장큰수 {
    /**
     * [6, 10, 2]	"6210"
     * [3, 30, 34, 5, 9]	"9534330"
     *
     * @param args
     */
    public static void main(String[] args) {
        PSG_가장큰수 psg_가장큰수 = new PSG_가장큰수();
        String solution = psg_가장큰수.solution(new int[]{3, 30, 34, 5, 9});
        System.out.println(solution);

    }

    public String solution(int[] numbers) {
        List<String> strList = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
        strList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if (strList.get(0).equals("0")) {
            return "0";
        }
        return String.join("", strList);
    }
}
