
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        List<Node>[] tree = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());

            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) {
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());
                tree[cur].add(new Node(next, cost));
            }
        }
        // 정점에서 먼곳
        int far = 1;
        int cost = 0;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[V + 1];

        queue.offer(new Node(1, 0));
        visited[1] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.cost > cost) {
                far = cur.cur;
                cost = cur.cost;
            }
            for (Node next : tree[cur.cur]) {
                if (!visited[next.cur]) {
                    visited[next.cur] = true;
                    queue.offer(new Node(next.cur, cur.cost + next.cost));
                }
            }
        }

        // 먼곳에서 먼곳으로
        queue = new ArrayDeque<>();
        visited = new boolean[V + 1];
        int ans = 0;

        queue.offer(new Node(far, 0));
        visited[far] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.cost > ans) {
                ans = cur.cost;
            }
            for (Node next : tree[cur.cur]) {
                if (!visited[next.cur]) {
                    visited[next.cur] = true;
                    queue.offer(new Node(next.cur, cur.cost + next.cost));
                }
            }
        }
        System.out.println(ans);
    }

    private static class Node {
        int cur, cost;
        public Node(int cur, int cost) {
            this.cur = cur;
            this.cost = cost;
        }
    }
}