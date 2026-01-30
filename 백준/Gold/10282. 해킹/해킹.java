import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            List<List<PC>> graph = new ArrayList<>();
            for (int i = 0; i < N+1; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int S = Integer.parseInt(st.nextToken());
//                graph.get(A).add(new PC(B, S));
                graph.get(B).add(new PC(A, S));
            }

            PriorityQueue<PC> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
            int[] dist = new int[N+1];
            Arrays.fill(dist,Integer.MAX_VALUE);

            pq.offer(new PC(C, 0));
            dist[C] = 0;

            while (!pq.isEmpty()) {
                PC cur = pq.poll();
                if(dist[cur.no] < cur.cost) continue;

                for (PC next : graph.get(cur.no)) {
                    if (dist[next.no] > dist[cur.no] + next.cost) {
                        dist[next.no] = dist[cur.no] + next.cost;
                        pq.offer(new PC(next.no, dist[next.no]));
                    }
                }
            }
            int max = 0;
            int cnt = 0;
            for (int i : dist) {
                if(i == Integer.MAX_VALUE) continue;
                cnt++;
                max = Math.max(max, i);
            }
            sb.append(cnt).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
    static class PC{
        int no, cost;
        PC(int no, int cost){
            this.no = no;
            this.cost = cost;
        }
    }
}