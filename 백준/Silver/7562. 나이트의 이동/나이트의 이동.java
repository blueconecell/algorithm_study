import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dc = {2, -2, 1, -1, 2, -2, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] knight = new int[2];
            knight[0] = Integer.parseInt(st.nextToken());
            knight[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] target = new int[2];
            target[0] = Integer.parseInt(st.nextToken());
            target[1] = Integer.parseInt(st.nextToken());

            ArrayDeque<Chess> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[N][N];
            q.offer(new Chess(knight, 0));

            while (!q.isEmpty()) {
                Chess cur = q.poll();
                if (visited[cur.point[0]][cur.point[1]]) continue;
                if(cur.point[0] == target[0] && cur.point[1] == target[1]) {
                    sb.append(cur.depth).append("\n");
                    break;
                }
                visited[cur.point[0]][cur.point[1]] = true;
                for (int i = 0; i < 8; i++) {
                    int nr = cur.point[0] + dr[i];
                    int nc = cur.point[1] + dc[i];
                    if(nr<0 || nc<0|| nr>=N || nc>=N || visited[nr][nc]) continue;
                    q.offer(new Chess(new int[]{nr, nc}, cur.depth + 1));
                }
            }
        }
        System.out.println(sb);
    }

    static class Chess {
        int[] point;
        int depth;

        public Chess(int[] point, int depth) {
            this.point = point;
            this.depth = depth;
        }
    }
}