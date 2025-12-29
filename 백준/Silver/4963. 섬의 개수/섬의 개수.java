
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {0, 0, 1, -1,1,1,-1,-1};
    static int[] dy = {1, -1, 0, 0,1,-1,1,-1};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            int[][] board = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean[][] visited = new boolean[h][w];
            int ans = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] == 1 && !visited[i][j]) {

                        ans++;
                        ArrayDeque<Node> queue = new ArrayDeque<>();
                        queue.offer(new Node(i, j));
                        visited[i][j] = true;

                        while (!queue.isEmpty()) {
                            Node cur = queue.poll();

                            for (int k = 0; k < 8; k++) {
                                int nx = dx[k] + cur.i;
                                int ny = dy[k] + cur.j;
                                if (nx < 0 || ny < 0 || nx >= h || ny >= w || visited[nx][ny] || board[nx][ny] == 0) {
                                    continue;
                                }
                                visited[nx][ny] = true;
                                queue.offer(new Node(nx, ny));
                            }
                        }
                    }
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static class Node {
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}