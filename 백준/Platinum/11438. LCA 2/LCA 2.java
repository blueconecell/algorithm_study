import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> tree;
    static boolean[] visited;
    static int[] depth;

    static int MAX_H = 17; // 2^17 승이 문제의 제한인 100_000 에서 나올 수 있는 최대 높이
    static int[][] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        visited = new boolean[N + 1];
        depth = new int[N + 1];
        parent = new int[MAX_H + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // N의 수가 커졌기 때문에 stackoverflow 발생가능하므로 bfs로 전환
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        depth[1] = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (Integer next : tree.get(cur)) {
                if (depth[next] == 0) {
                    depth[next] = depth[cur]+1;
                    parent[0][next] = cur;
                    q.offer(next);
                }
            }
        }

        // dp 테이블 채우기
        for (int i = 1; i < MAX_H + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                // i의 4번째 조상은 i의 2번째 조상의 2번째 조상이다.
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lca(a, b)).append("\n");
        }
        System.out.println(sb);
    }


    private static int lca(int a, int b) {
        // b 가 a 보다 깊도록 설정
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // a,b를 같은 높이까지 점프
        for (int i = MAX_H; i >= 0; i--) {
            if (depth[b] - depth[a] >= (1 << i)) {
                b = parent[i][b];
            }
        }

        if(a==b) return a;
        for (int i = MAX_H; i>=0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }
}