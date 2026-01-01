
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] W, dp;
    static int INF = 16_000_001;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][(1 << N)]; // 비트마스킹을 위한 shift 연산자 2의 N승

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = dfs(0, 1);
        System.out.println(ans);
    }

    /**
     * @param cur     : 현재 도시
     * @param visited : 방문여부를 비트마스킹으로 표현하므로 int 형
     */
    static int dfs(int cur, int visited) {

        // 종료시점 : 현재 도시에서 시작지점으로 갔을 때
        if (visited == ((1 << N) - 1)) {
            if (W[cur][0] == 0) return INF;
            return W[cur][0];
        }

        // -1이 아니면 이미 계산 완료된 상태(실패한 경로 포함)이므로 바로 반환
        if (dp[cur][visited] != -1) {
            return dp[cur][visited];
        }
        // 계산 시작: 일단 INF로 초기화하여 방문 표시
        dp[cur][visited] = INF;

        for (int i = 0; i < N; i++) {
            // 1. 아직 방문하지 않았고 && 2. 가는 길이 있는 경우만 탐색
            if ((visited & (1 << i)) == 0 && W[cur][i] != 0) {
                int next = dfs(i, visited | (1 << i));

                // 다음 경로에서 돌아오는 길이 있는 경우만 최솟값 갱신
                if (next != INF) {
                    dp[cur][visited] = Math.min(dp[cur][visited], next + W[cur][i]);
                }
            }
        }
        return dp[cur][visited];
    }
}