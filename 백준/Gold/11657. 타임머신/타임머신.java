import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int MAX = Integer.MAX_VALUE;

        Edge[] edges = new Edge[M];
        long[] dist = new long[N + 1];
        for (int i = 2; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, v);
        }
        boolean flag = false;
        for (int i = 1; i < N+1; i++) {
            for (int j = 0; j < M; j++) {
                Edge e = edges[j];
                if (dist[e.from] != Integer.MAX_VALUE && dist[e.to] > dist[e.from] + e.weight) {
                    dist[e.to] = dist[e.from] + e.weight;

                    if (i == N) {
                        flag = true;
                    }
                }
            }
        }
        if (flag) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i < N+1; i++) {
                if(dist[i] == Integer.MAX_VALUE) {
                    sb.append(-1).append("\n");
                }else{
                    sb.append(dist[i]).append("\n");
                }
            }
            System.out.println(sb);
        }
    }
    static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}