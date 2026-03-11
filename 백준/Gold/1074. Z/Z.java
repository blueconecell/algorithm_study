import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, 1, 1};
    static int[] dy = {0, 1, 0, 1};

    static int[][] board;
    static int num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

//        board = new int[(int) Math.pow(2,N)][(int) Math.pow(2,N)];

        num = 0;

        System.out.println(memory(N, r, c));

    }

    static int memory(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }
        int half = (int) Math.pow(2, n - 1);
        int powHalf = half * half;
        if (r < half && c < half) {
            return memory(n - 1, r, c);
        } else if (r < half && c >= half) {
            return powHalf * 1 + memory(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            return powHalf * 2 + memory(n - 1, r - half, c);
        } else {
            return powHalf * 3 + memory(n - 1, r - half, c - half);
        }
    }

    static void init(int[] cur, int n) {

        if (n == 1) {

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];
                board[nx][ny] = num++;
            }
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] * (int) Math.pow(2, n - 1) + cur[0];
                int ny = dy[i] * (int) Math.pow(2, n - 1) + cur[1];
                init(new int[]{nx, ny}, n - 1);
            }
        }

    }
}