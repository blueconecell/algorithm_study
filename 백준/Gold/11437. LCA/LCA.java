import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> tree;
    static boolean[] visited;
    static int[] depth ;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        visited = new boolean[N+1];
        depth = new int[N + 1];
        parent = new int[N + 1];

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
        dfs(1, 1);

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

    private static void dfs(int cur, int d) {
        visited[cur] = true;
        depth[cur] = d;
        for (Integer i : tree.get(cur)) {
            if (!visited[i]) {
                parent[i] = cur;
                dfs(i, d + 1);
            }
        }
    }

    private static int lca(int aa, int bb) {
        int a = aa;
        int b = bb;
        while (depth[a] != depth[b]) {
            if(depth[a]>depth[b]) {
                a = parent[a];
            }else{
                b = parent[b];
            }
        }
        while (a != b) {

            a = parent[a];
            b = parent[b];
        }
        return a;
    }

}