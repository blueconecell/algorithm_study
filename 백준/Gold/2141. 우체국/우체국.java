import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] villages = new long[n][2];
        long total = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            villages[i][0] = Long.parseLong(st.nextToken()); // 좌표
            villages[i][1] = Long.parseLong(st.nextToken()); // 인구
            total += villages[i][1];
        }

        Arrays.sort(villages, (a, b) -> Long.compare(a[0], b[0]));

        long cumulative = 0;
        for (long[] v : villages) {
            cumulative += v[1];
            if (cumulative * 2 >= total) {
                System.out.println(v[0]);
                return;
            }
        }
    }
}