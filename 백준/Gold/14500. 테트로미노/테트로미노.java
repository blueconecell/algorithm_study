
import java.util.*;
import java.io.*;

public class Main {
    static int N, M, ans;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = 0;

        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(1, arr[i][j], i, j);
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                iron(i, j);
            }
        }
        System.out.println(ans);
    }

    static void iron(int i, int j) {
        int center = arr[i][j];

        int[] ii = {1, -1, 0, 0};
        int[] jj = {0, 0, 1, -1};
        int minSide = 1_001;
        int sides = 0;
        int cnt =0;
        for (int d = 0; d < 4; d++) {
            int nx = i + ii[d];
            int ny = j + jj[d];
            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            cnt++;
            minSide = Math.min(minSide, arr[nx][ny]);
            sides += arr[nx][ny];
        }
        if (cnt == 4) {
            sides -= minSide;
        }
        ans = Math.max(ans, sides + center);
    }

    static void dfs(int depth, int sum, int i, int j) {

        if (depth == 4) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
                continue;
            }
            visited[nx][ny] = true;
            dfs(depth + 1, sum + arr[nx][ny], nx, ny);
            visited[nx][ny] = false;
        }
    }
}