
import java.util.*;
import java.io.*;

public class Main {

    static int[][] board;
    static int ans, n, m;

    // 델타 : 상 하 좌 우 순서
    static int[] dn = {-1, 1, 0, 0};
    static int[] dm = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 감시카메라 5는 먼저 처리
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 5) {
                    for (int d = 0; d < 4; d++) {
                        detect(i, j, d);
                    }
                }
            }
        }

        // 감시카메라 1~4에 대해서 가능한 모든 방향 고려하여 백트래킹
        bt(0, 0);
        System.out.println(ans);
    }

    static void bt(int i, int j) {
        if (j == m) {
            bt(i + 1, 0);
            return;
        }
        if (i == n) {
            int tempAns = 0;
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < m; l++) {
                    if (board[k][l] == 0) {
                        tempAns++;
                    }
                }
            }
            ans = Math.min(ans, tempAns);
            return;
        }

        int v = board[i][j];
        if (v >= 1 && 4 >= v) {
            switch (v) {
                case 1:
                    for (int d = 0; d < 4; d++) {
                        detect(i, j, d);
                        bt(i, j + 1);
                        rollback(i, j, d);
                    }
                    break;
                case 2:
                    for (int d = 0; d < 4; d += 2) {
                        detect(i, j, d);
                        detect(i, j, d + 1);
                        bt(i, j + 1);
                        rollback(i, j, d);
                        rollback(i, j, d + 1);
                    }
                    break;
                case 3:
                    for (int d1 = 0; d1 < 2; d1++) {
                        for (int d2 = 2; d2 < 4; d2++) {
                            detect(i, j, d1);
                            detect(i, j, d2);
                            bt(i, j + 1);
                            rollback(i, j, d1);
                            rollback(i, j, d2);
                        }
                    }
                    break;
                case 4:
                    for (int d = 0; d < 4; d++) {
                        detect(i, j, d);
                        detect(i, j, (d + 1) % 4);
                        detect(i, j, (d + 2) % 4);
                        bt(i, j + 1);
                        rollback(i, j, d);
                        rollback(i, j, (d + 1) % 4);
                        rollback(i, j, (d + 2) % 4);
                    }
                    break;
            }
        } else {
            bt(i, j + 1);
        }

    }

    static void detect(int i, int j, int dir) {
        int temp = 1;
        while (i + temp * dn[dir] >= 0 && n > i + temp * dn[dir] && j + temp * dm[dir] >= 0 && m > j + temp * dm[dir]) {

            if (board[i + temp * dn[dir]][j + temp * dm[dir]] <= 0) {
                board[i + temp * dn[dir]][j + temp * dm[dir]]--;
            } else if (board[i + temp * dn[dir]][j + temp * dm[dir]] == 6) {
                break;
            }
            temp++;
        }
    }

    static void rollback(int i, int j, int dir) {
        int temp = 1;
        while (i + temp * dn[dir] >= 0 && n > i + temp * dn[dir] && j + temp * dm[dir] >= 0 && m > j + temp * dm[dir]) {
            if (board[i + temp * dn[dir]][j + temp * dm[dir]] < 0) {
                board[i + temp * dn[dir]][j + temp * dm[dir]]++;
            } else if (board[i + temp * dn[dir]][j + temp * dm[dir]] == 6) {
                break;
            } else if (board[i + temp * dn[dir]][j + temp * dm[dir]] == 0) {
                System.out.println("롤백 잘못 됨 !!!!!");
                System.exit(0);
            }
            temp++;
        }
    }
}

