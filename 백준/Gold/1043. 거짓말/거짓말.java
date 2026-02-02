import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    static void init(int N){
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
    }
    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa == pb) return false;
        parent[pa] = pb;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        init(N);

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int[] T_arr = new int[T];
        for (int i = 0; i < T; i++) {
            T_arr[i] = Integer.parseInt(st.nextToken());
            union(0, T_arr[i]);
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            parties.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                parties.get(i).add(Integer.parseInt(st.nextToken()));
            }
            for (int j = 0; j < n - 1; j++) {
                union(parties.get(i).get(j), parties.get(i).get(j+1));
            }
        }

        int cnt = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int i : party) {
                if (find(i) == find(0)) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) cnt++;
        }
        System.out.println(cnt);
    }
}