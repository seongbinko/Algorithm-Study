package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2304_창고다각형 {

    /*
    창고 다각형의 면적이 가장 작은 창고를 만들기를 원한다.
    기둥들의 위치와 높이가 주어질 때, 가장 작은 창고 다각형의 면적을 구하는 프로그램을 작성하시오.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //기둥의 개수
        int N = Integer.parseInt(st.nextToken());

        //가장 높은 기둥
        int highX = 0;
        int highY = 0;

        //y좌표 값
        int[] coord = new int[1001]; //1000 -> 1001로 바꾸어서 런타임 에러 (ArrayIndexOutOfBounds)

        //기둥 왼쪽면의 위치 L, 높이 H = x좌표 y좌표
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coord[x] = y;

            if(highY < y){
                highY = y;
                highX = x;
            }
        }

        int leftarea = 0;

        //왼쪽부터 가장 높은기둥까지 높이를 재설정한다
        for (int i = 1; i <= highX; i++) {

            if(coord[i] < coord[i-1]){
                coord[i] = coord[i-1];
            }

            leftarea = leftarea + coord[i-1];
        }

        int rightarea = 0;

        //오른쪽부터 가장 높은기둥까지 높이를 재설정한다
        for (int i = 1000; i > highX; i--) {

            if(coord[i-1] < coord[i]){
                coord[i-1] = coord[i];
            }

            rightarea = rightarea + coord[i];
        }

        System.out.println(leftarea + rightarea + highY);

    }
}


