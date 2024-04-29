package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2304_창고다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 10

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }
        list.sort((a,b) -> a[0] - b[0]);
        int prevHeight = 0;
        int prevIndex = 0;
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            if(prevHeight < list.get(i)[1]){
                result += (list.get(i)[0] - prevIndex) * prevHeight;
                prevIndex = list.get(i)[0];
                prevHeight = list.get(i)[1];
            }
        }
        int firstIndex = prevIndex;
        int tempHeight = prevHeight;
        prevHeight = 0;
        prevIndex = 0;
        for(int i = n-1 ; i >= 0 ; i--){
            if(prevHeight < list.get(i)[1]){
                result += (prevIndex - list.get(i)[0]) * prevHeight;
                prevIndex = list.get(i)[0];
                prevHeight = list.get(i)[1];
            }
        }
        int secondIndex = prevIndex;
        result += (secondIndex - firstIndex + 1) * tempHeight;
        System.out.println(result);
    }
}
