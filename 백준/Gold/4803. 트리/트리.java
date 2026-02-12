import java.util.*;
import java.io.*;

public class Main {

    static int[] parents;
    static boolean[] hasCycle;

    static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) {
            hasCycle[rootA] = true;
        }else{
            parents[rootA] = rootB;
            if (hasCycle[rootA]) {
                hasCycle[rootB] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            parents = new int[N + 1];
            hasCycle = new boolean[N + 1];
            for (int i = 1; i < N + 1; i++) {
                parents[i] = i;
            }


            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            int treeCnt = 0;
            for (int i = 1; i < N+1; i++) {
                if(parents[i] == i && !hasCycle[i]){
                    treeCnt++;
                }
            }

            sb.append("Case ").append(T).append(": ");
            if (treeCnt == 0) {
                sb.append("No trees.\n");
            } else if (treeCnt == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(treeCnt).append(" trees.\n");
            }
            T++;
        }
        System.out.println(sb);
    }

    static class Edge {
        int cur, parent;

        public Edge(int cur, int parent) {
            this.cur = cur;
            this.parent = parent;
        }
    }

}