import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Integer>[] adj;
    static int[] route, firstIdx, depths;
    static int[] segTree;
    static int routeIdx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        // 1. 오일러 경로 순회 준비
        route = new int[2 * N];      // 방문 순서대로 노드 번호 저장
        firstIdx = new int[N + 1];   // 각 노드가 route에 처음 등장하는 인덱스
        depths = new int[N + 1];     // 각 노드의 실제 깊이

        // 2. DFS 수행 (루트=1, 깊이=0)
        dfs(1, 0, 0);

        // 3. 세그먼트 트리 구축 (route 배열 기준)
        int len = routeIdx;
        segTree = new int[4 * len];
        build(1, 0, len - 1);

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // u와 v의 등장 위치 중 작은 쪽을 L, 큰 쪽을 R로 설정
            int L = Math.min(firstIdx[u], firstIdx[v]);
            int R = Math.max(firstIdx[u], firstIdx[v]);

            // 구간 [L, R]에서 깊이가 최소인 노드 번호를 쿼리
            sb.append(query(1, 0, len - 1, L, R)).append("\n");
        }
        System.out.print(sb);
    }

    // 오일러 경로 순회: 돌아올 때도 기록하여 구간을 형성함
    static void dfs(int cur, int p, int d) {
        depths[cur] = d;
        firstIdx[cur] = routeIdx;
        route[routeIdx++] = cur;

        for (int next : adj[cur]) {
            if (next != p) {
                dfs(next, cur, d + 1);
                route[routeIdx++] = cur; // 자식 방문 후 부모로 돌아옴을 기록
            }
        }
    }

    // 세그먼트 트리 빌드: 구간 내에서 '깊이'가 최소인 '노드 번호'를 저장
    static int build(int node, int start, int end) {
        if (start == end) return segTree[node] = route[start];

        int mid = (start + end) / 2;
        int leftNode = build(node * 2, start, mid);
        int rightNode = build(node * 2 + 1, mid + 1, end);

        // 왼쪽 자식과 오른쪽 자식 중 깊이가 더 얕은 노드를 선택
        return segTree[node] = (depths[leftNode] < depths[rightNode]) ? leftNode : rightNode;
    }

    // 구간 최소 쿼리 (RMQ)
    static int query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return -1;
        if (left <= start && end <= right) return segTree[node];

        int mid = (start + end) / 2;
        int lRes = query(node * 2, start, mid, left, right);
        int rRes = query(node * 2 + 1, mid + 1, end, left, right);

        if (lRes == -1) return rRes;
        if (rRes == -1) return lRes;
        return (depths[lRes] < depths[rRes]) ? lRes : rRes;
    }
}