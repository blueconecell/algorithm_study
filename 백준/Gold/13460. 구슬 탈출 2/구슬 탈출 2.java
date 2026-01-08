
import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M, ans;
    static int[][] board;
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()) - 2;
        M = Integer.parseInt(st.nextToken()) - 2;
        board = new int[N][M];
        visited = new boolean[N][M][N][M];
        st = new StringTokenizer(br.readLine());
        Ball R = new Ball();
        Ball B = new Ball();
        Ball End = new Ball();
        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split("");
            int idx = 1;
            for (int j = 0; j < M; j++) {
                String s = tokens[idx++];

                if (s.equals(".")) {
                    board[i][j] = 0;
                } else if (s.equals("R")) {
                    board[i][j] = 1;
                    R.x = i;
                    R.y = j;
                } else if (s.equals("B")) {
                    board[i][j] = 2;
                    B.x = i;
                    B.y = j;
                } else if (s.equals("O")) {
                    board[i][j] = 3;
                    End.x = i;
                    End.y = j;
                } else if (s.equals("#")) {
                    board[i][j] = 4;
                }
            }
        }
        st = new StringTokenizer(br.readLine());

        ArrayDeque<Game> queue = new ArrayDeque<>();
        queue.offer(new Game(R, B, 0));
        visited[R.x][R.y][B.x][B.y] = true;

        ans = -1;
        while (!queue.isEmpty()) {
            Game cur = queue.poll();
            if (cur.cnt >= 10) continue;

            for (int i = 0; i < 4; i++) {
                Ball nextRed = new Ball(cur.red.x, cur.red.y);
                Ball nextBlue = new Ball(cur.blue.x, cur.blue.y);

                int rDist = move(nextRed, dx[i], dy[i]);
                int bDist = move(nextBlue, dx[i], dy[i]);

                if (board[nextBlue.x][nextBlue.y] == 3) {
                    continue;
                }

                if (board[nextRed.x][nextRed.y] == 3) {
                    ans = cur.cnt + 1;
                    System.out.println(ans);
                    return;
                }
                if (nextRed.x == nextBlue.x && nextRed.y == nextBlue.y) {
                    if (rDist > bDist) {
                        nextRed.x -= dx[i];
                        nextRed.y -= dy[i];
                    } else {
                        nextBlue.x -= dx[i];
                        nextBlue.y -= dy[i];
                    }
                }
                if (!visited[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y]) {
                    visited[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y] = true;
                    queue.offer(new Game(nextRed, nextBlue, cur.cnt + 1));
                }
            }
        }
        System.out.println(ans);
    }

    static private int move(Ball ball, int x, int y) {
        int dist = 0;
        while (ball.x + x >= 0 && ball.x + x < N && ball.y + y >= 0 && ball.y + y < M && board[ball.x + x][ball.y + y] != 4) {
            ball.x += x;
            ball.y += y;
            dist++;
            if (board[ball.x][ball.y] == 3) {
                break;
            }
        }
        return dist;
    }

    private static class Game {
        private final Ball red;
        private final Ball blue;
        private final int cnt;

        public Game(Ball red, Ball blue, int cnt) {
            this.red = red;
            this.blue = blue;
            this.cnt = cnt;
        }

        public Ball red() {
            return red;
        }

        public Ball blue() {
            return blue;
        }

        public int cnt() {
            return cnt;
        }
    }

    private static class Ball {
        int x, y;

        public Ball(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Ball() {
        }
    }
}