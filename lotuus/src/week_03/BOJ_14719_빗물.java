package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {

    /*

    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        //가장 높은 블럭
        int highW = 0;
        int highH = 0;

        int[] block = new int[W+1];
        int blockarea = 0;
        st = new StringTokenizer(br.readLine());
        for (int w = 0; w < W; w++) {
            int h = Integer.parseInt(st.nextToken());
            block[w] = h;

            if(highH < h){
                highH = h;
                highW = w;
            }

            blockarea = blockarea + h;
        }

        int leftarea = 0;
        for (int i = 1; i <= highW; i++) {
            if(block[i] < block[i-1]){
                block[i] = block[i-1];
            }
            leftarea = leftarea + block[i-1];
        }

        int rightarea = 0;
        for (int i = W; i > highW; i--) {
            if(block[i-1] < block[i]){
                block[i-1] = block[i];
            }
            rightarea = rightarea + block[i];
        }

        System.out.println(leftarea + rightarea + highH - blockarea);





    }

}
