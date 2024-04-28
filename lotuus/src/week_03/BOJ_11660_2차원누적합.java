package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660_2차원누적합 {

    /*

    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //표의 크기 N
        int M = Integer.parseInt(st.nextToken()); //구해야하는 좌표 개수

        int[][] graph = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //x1, y1, x2, y2
        int[][] coord = new int[M][4];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            coord[i][0] = Integer.parseInt(st.nextToken());
            coord[i][1] = Integer.parseInt(st.nextToken());
            coord[i][2] = Integer.parseInt(st.nextToken());
            coord[i][3] = Integer.parseInt(st.nextToken());
        }

        int[][] prefixGraph = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int overlap = prefixGraph[i-1][j-1];
                int top = prefixGraph[i][j-1];
                int left = prefixGraph[i-1][j];
                int self = graph[i][j];
                prefixGraph[i][j] = top + left - overlap + self;

//                System.out.print(prefixGraph[i][j] + " ");
            }
//            System.out.println();
        }

        for (int i = 0; i < M; i++) {
            int x1 = coord[i][0];
            int y1 = coord[i][1];
            int x2 = coord[i][2];
            int y2 = coord[i][3];

            int overlap = prefixGraph[x1-1][y1-1];
            int top = prefixGraph[x2][y1-1];
            int left = prefixGraph[x1-1][y2];
            int self = prefixGraph[x2][y2];

            System.out.println(self - left - top + overlap);

        }




    }

}
