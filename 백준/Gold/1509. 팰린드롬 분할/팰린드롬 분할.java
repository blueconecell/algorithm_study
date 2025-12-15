
import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] raw = br.readLine().split("");
        int N = raw.length;
        String[] input = new String[N + 1];
        for (int i = 0; i < N; i++) {
            input[i + 1] = raw[i];
        }

        boolean[][] dp = new boolean[N + 1][N + 1];
        int[] ansDp = new int[N + 1];
        Arrays.fill(ansDp, Integer.MAX_VALUE);
        ansDp[0] = 0;

        // dp 1

        for (int i = 1; i < N + 1; i++) {
            dp[i][i] = true;
        }

        // dp 2
        for (int i = 1; i < N; i++) {
            if (input[i].equals(input[i + 1])) {
                dp[i][i + 1] = true;
            }
        }

        // dp 3 over
        for (int len = 3; len < N + 1; len++) {
            for (int start = 1; start <= N - len + 1; start++) {
                int end = start + len-1;
                if (input[start].equals(input[end]) && dp[start+1][end-1]) {
                    dp[start][end] = true;
                }
            }
        }


        for (int end = 1; end < N + 1; end++) {
            for (int start = 1; start <= end; start++) {
                if (dp[start][end]) { // 만약 start ~ end 까지 회문이라면 +1을 해야함
                    ansDp[end] = Math.min(ansDp[end], ansDp[start - 1] + 1); // 0번째부터 start 까지 회문 + 1과 이때까지(end)의 회문을 비교
                }
            }
        }
        System.out.println(ansDp[N]);


    }
}