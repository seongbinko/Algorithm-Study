import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PGS_k진수에서_소수_개수_구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = solution(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        System.out.println(answer);
    }


    public static int solution(long n, long k) {
        int answer = 0;

        //양의 정수 N
        //K진수

        //K 진수 변환
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, n % k); //N을 K로 나눈 나머지를 맨 앞자리부터 입력해준다
            n = n / k; //N을 K로 나누어준다
        }
        String convertedN = sb.toString();
        // 10진수 23를 3진수로 변환한다면
        // sb.insert(0, (23 % 3)), sb =   2, n = (23/3), n = 7
        // sb.insert(0, ( 7 % 3)), sb =  12, n = ( 7/3), n = 2
        // sb.insert(0, ( 2 % 3)), sb = 212, n = ( 2/3), n = 0


        //조건에 맞는 P 찾기
        //0P0처럼 소수 양쪽에 0이 있는 경우
        //P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
        //0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
        //P처럼 소수 양쪽에 아무것도 없는 경우
        //단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
        //예를 들어, 101은 P가 될 수 없습니다.

        String[] splits = convertedN.split("0");
        //splits = [211, 2, 1, 1, 11]
        for (String split : splits) {

            if(split.isBlank()){
                continue;
            }

            if(isPrime(Long.parseLong(split))){
                answer ++;
            }

        }

        return answer;
    }

    private static boolean isPrime(Long number) {

        //1은 소수가 아님
        if(number == 1){
            return false;
        }

        //해당 수의 제곱근까지만 확인하면된다
        for (long i = 2; i <= Math.sqrt(number); i++) {

            //만약 나누어떨어지는 부분이 하나라도 있으면 소수 아님
            if(number % i == 0){
                return false;
            }
        }

        //나누어 떨어지는 부분이 한번도 없었음. 소수!
        return true;
    }

}
