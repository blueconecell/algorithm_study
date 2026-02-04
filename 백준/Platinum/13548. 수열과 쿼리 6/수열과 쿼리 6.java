import java.util.*;
import java.io.*;

public class Main {
    static int ans;
    static int[] cnt, table;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sqrtN = Math.max(1, (int) Math.sqrt(N));

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] result = new int[M];
        Query[] queries = new Query[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            queries[i] = new Query(l, r, i);
        }

        Arrays.sort(queries, (q1, q2) -> {
            int block1 = q1.l / sqrtN;
            int block2 = q2.l / sqrtN;
            if (block1 != block2) {
                return block1 - block2;
            }
            if (block1 % 2 == 0) return q1.r - q2.r;
            else return q2.r - q1.r;
        });
        cnt = new int[1_000_001];
        table = new int[1_000_001];

        int curL = 1;
        int curR = 0;
        for (int i = 0; i < M; i++) {
            Query q = queries[i];

            while (curL > q.l) add(arr[--curL]);
            while (curR < q.r) add(arr[++curR]);
            while (curL < q.l) remove(arr[curL++]);
            while (curR > q.r) remove(arr[curR--]);
            result[q.idx] = ans;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);


    }

    static void add(int v) {
        if (cnt[v] > 0) {
            table[cnt[v]]--;
        }
        cnt[v]++;
        table[cnt[v]]++;
        if (ans < cnt[v]) {
            ans = cnt[v];
        }
    }

    static void remove(int v) {
        table[cnt[v]]--;
        if (cnt[v] == ans && table[cnt[v]] == 0) {
            ans--;
        }
        cnt[v]--;
        if (cnt[v] > 0) table[cnt[v]]++;
    }

    static class Query {
        int l, r, idx;

        public Query(int l, int r, int idx) {
            this.l = l;
            this.r = r;
            this.idx = idx;
        }
    }
}