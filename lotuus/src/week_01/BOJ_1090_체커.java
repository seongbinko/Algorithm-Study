package week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

//TODO 다시풀기
public class BOJ_1090_체커 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력받기
        int count = Integer.parseInt(br.readLine());
        int[] xArr = new int[count];
        int[] yArr = new int[count];
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xArr[i] = Integer.parseInt(st.nextToken());
            yArr[i] = Integer.parseInt(st.nextToken());
        }

        //만날 장소 좌표 만들기
        List<Coord> coords = new ArrayList<>();
        for (int x = 0; x < count; x++) {
            for (int y = 0; y < count; y++) {
                coords.add(new Coord(
                        xArr[x], yArr[y]
                ));
            }
        }

        int[] answer = new int[count];
        Arrays.fill(answer, -1);


        //좌표마다 비교
        for (Coord coord : coords) {
//            System.out.println(coord);

            int[] dist = new int[count];

            //사람별 이동거리 계산
            for (int i = 0; i < count; i++) {
                int absX = Math.abs(coord.getX() - xArr[i]);
                int absY = Math.abs(coord.getY() - yArr[i]);
                dist[i] = absX + absY;

//                System.out.println("    [" + xArr[i] + "," + yArr[i] + "] " + (absX + absY));
            }

            //TODO 여기서부터 다시풀어보기

            //가까운 순서대로 정렬
            Arrays.sort(dist);

            int temp = 0;
            for (int i = 0; i < dist.length; i++) {
                temp = temp + dist[i];

                if(answer[i] == -1){
                    answer[i] = temp;
                }else{
                    answer[i] = Math.min(temp, answer[i]);
                }
            }
        }

        //사람들 마다 최소 이동거리 출력
        System.out.println(Arrays.toString(answer));

    }
}


class Coord {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "["+x+","+y+"]";
    }
}
