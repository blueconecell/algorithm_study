
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node>[] tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            tree[from].add(new Node(to, cost));
            tree[to].add(new Node(from, cost));
        }

        // 1. root -> far
        ArrayDeque<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        int far = 1;
        int ans = 0;

        queue.add(new Node(1, 0));
        visited[1] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.cost > ans) {
                ans = cur.cost;
                far = cur.cur;
            }
            for (Node next : tree[cur.cur]) {
                if (!visited[next.cur]) {
                    visited[next.cur] = true;
                    queue.offer(new Node(next.cur, cur.cost + next.cost));
                }
            }
        }

        // 2. far -> far
        queue = new ArrayDeque<>();
        visited = new boolean[N + 1];


        queue.add(new Node(far, 0));
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