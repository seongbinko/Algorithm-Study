package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14252_공약수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        //수를 중간중간 추가하기 위해 list로 받는다
        List<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(Integer.valueOf(st.nextToken()));
        }

        //정렬
        Collections.sort(list);

        int GCD = 1;

        //인접한 두 수의 공약수 1이 되도록
        for (int i = 0; i < list.size()-1; i++) {
            Integer a = list.get(i);
            Integer b = list.get(i + 1);

            if(GCD(a, b) == 1){
                continue;
            }else{



            }
        }


    }

    public static int GCD(int a, int b){
        while ( a % b != 0 ){ //나머지가 없어지는 순간 멈춘다
            //나머지 계산
            int temp = a % b;

            //위치바꾸기
            a = b;
            b = temp;
        }
        return b;
    }

    public static int LCM(int a, int b){
        return (a * b) / GCD(a, b);
    }

}
