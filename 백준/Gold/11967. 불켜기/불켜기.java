import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Point>[][] map = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[x][y].add(new Point(a, b));
        }
        ArrayDeque<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N + 1][N + 1];
        boolean[][] isBright = new boolean[N + 1][N + 1];

        q.offer(new Point(1, 1));
        visited[1][1] = true;
        isBright[1][1] = true;

        int ans = 1;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (Point p : map[cur.x][cur.y]) {
                if (!isBright[p.x][p.y]) {
                    isBright[p.x][p.y] = true;
                    ans++;

                    for (int i = 0; i < 4; i++) {
                        int nx = p.x + dx[i];
                        int ny = p.y + dy[i];
                        if (nx > 0 && ny > 0 && nx <= N && ny <= N && visited[nx][ny]) {
                            if (!visited[p.x][p.y]) {
                                visited[p.x][p.y] = true;
                                q.offer(p);
                            }
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx<=0 || ny<=0 || nx>N || ny>N || visited[nx][ny]) {
                    continue;
                }
                if(isBright[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }
        System.out.println(ans);
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}