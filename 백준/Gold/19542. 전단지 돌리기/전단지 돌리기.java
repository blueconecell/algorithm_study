import java.util.*;
import java.io.*;

public class Main {

    static int N, S, D, cnt;
    static List<List<Integer>> tree;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        depth = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        dfs(S, -1);
        System.out.println(cnt * 2);
    }

    static int dfs(int idx, int parent) {
        for (int next : tree.get(idx)) {
            if (next != parent) {
                depth[idx] = Math.max(depth[idx], dfs(next, idx) + 1);
            }
        }
        if (idx != S && depth[idx] >= D) {
            cnt++;
        }
        return depth[idx];

    }
}