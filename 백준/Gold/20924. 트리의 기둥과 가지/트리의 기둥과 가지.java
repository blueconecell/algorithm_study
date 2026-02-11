import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<Edge>[] tree = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            tree[a].add(new Edge(b, d));
            tree[b].add(new Edge(a, d));
        }
        int trunk = 0;
        int branch = 0;

        ArrayDeque<Edge> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        queue.offer(new Edge(R, 0));
        visited[R] = true;
        boolean isTrunk = true;

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            int childCnt = 0;
            for (Edge e : tree[cur.next]) {
                if (!visited[e.next]) {
                    childCnt++;
                }
            }

            if(isTrunk) {
                if(childCnt>=2 || childCnt==0) {
                    isTrunk = false;
                    trunk = cur.cost;
                    cur.cost = 0;
                }
            }

            if (childCnt == 0) {
                branch = Math.max(cur.cost, branch);
            }
            for (Edge next : tree[cur.next]) {
                if(!visited[next.next]){
                    visited[next.next] = true;
                    queue.offer(new Edge(next.next, cur.cost + next.cost));
                }
            }
        }
        System.out.println(trunk+" "+branch);

    }
    static class Edge{
        int next, cost;
        public Edge(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
}