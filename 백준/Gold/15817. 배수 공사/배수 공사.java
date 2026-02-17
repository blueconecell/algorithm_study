import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] dp = new int[X + 1];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            for (int j = X; j >= 1; j--) {
                for (int k = 1; k <= C; k++) {
                    int currentPipeLength = L * k;
                    if (j >= currentPipeLength) {
                        dp[j] += dp[j - currentPipeLength];
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(dp[X]);
    }
}