import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] map, dp;
    static int[] dcol = {1, 0, -1, 0};
    static int[] drow = {0, 1, 0, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0));
    }

    static int dfs(int col, int row) {
        if (col == M - 1 && row == N - 1) {
            dp[col][row]++;
            return 1;
        }
        int cur = map[col][row];

        if (dp[col][row] != -1) {
            return dp[col][row];
        }
        dp[col][row]=0;

        for (int i = 0; i < 4; i++) {
            int ncol = dcol[i] + col;
            int nrow = drow[i] + row;
            if (ncol < 0 || ncol >= M || nrow < 0 || nrow >= N) {
                continue;
            }
            if (map[ncol][nrow] < cur) {
                dp[col][row] += dfs(ncol, nrow);
            }
        }
        return dp[col][row];
    }
}