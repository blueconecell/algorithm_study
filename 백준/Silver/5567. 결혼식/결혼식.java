import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        cnt = 0;
        visited = new boolean[N + 1];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(1, 0));
        visited[1] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int f : graph.get(cur.idx)) {
                if (!visited[f]) {
                    visited[f] = true;
                    if (cur.depth < 2) {
                        queue.offer(new Node(f, cur.depth + 1));
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    static class Node {
        int idx, depth;

        public Node(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }
    }

}