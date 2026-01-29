import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<Integer> houses = new ArrayList<>();
        int[] cons = new int[Q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) {
            houses.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            cons[i] = Integer.parseInt(st.nextToken());
        }


        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        int[] dist = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < Q; i++) {
            pq.offer(new Node(cons[i], 0));
            dist[cons[i]] = 0;
        }
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.num] < cur.cost) {
                continue;
            }
            for (Node next : graph.get(cur.num)) {
                if (dist[next.num] > next.cost + cur.cost) {
                    dist[next.num] = next.cost + cur.cost;
                    pq.offer(new Node(next.num, dist[next.num]));
                }
            }
        }

        Collections.sort(houses);

        int min = Integer.MAX_VALUE;
        int ans = houses.get(0);

        for (Integer h : houses) {
            if (dist[h] < min) {
                min = dist[h];
                ans = h;
            }
        }

        System.out.println(ans);
    }

    static class Node {
        int num, cost;

        Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}