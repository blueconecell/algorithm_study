
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = br.readLine().split("");
        String[] b = br.readLine().split("");
        int na = a.length;
        int nb = b.length;
        int[][] dp = new int[nb + 1][na + 1];
        int ans = 0;

        for (int i = 1; i < na + 1; i++) {
            if (a[i - 1].equals(b[0])) {
                dp[1][i] = 1;
            } else {
                dp[1][i] = 0;
            }
        }

        for (int i = 2; i < nb + 1; i++) {
            for (int j = 1; j < na + 1; j++) {
                if (b[i - 1].equals(a[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(ans);
    }
}