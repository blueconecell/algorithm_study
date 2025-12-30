
import java.util.*;
import java.io.*;

public class Main {
    static int[] p;
    static void init(){
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
    }
    static int find(int a){
        if(p[a] == a){
            return a;
        }else{
            return p[a] = find(p[a]);
        }
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa == pb){
            return false;
        }
        p[pa] = find(pb);
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        p = new int[N];
        init();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int from = i;
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) {
                    graph.get(from).add(j);
                    graph.get(j).add(from);
                    union(from, j);
                }
            }
        }

        int[] travel = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            travel[i] = Integer.parseInt(st.nextToken())-1;
        }
        for (int i = 0; i < M-1; i++) {
            if(union(travel[i], travel[i+1])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}

