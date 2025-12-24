
import java.util.*;
import java.io.*;

public class Main {

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bt(0, 0);
    }

    static void bt(int i, int j) {
        if (j == 9) {
            // 줄바꾸기
            bt(i + 1, 0);
            return;
        }
        if (i == 9) {
            // 완전 종료
            for (int k = 0; k < 9; k++) {
                for (int l = 0; l < 9; l++) {
                    System.out.print(board[k][l] + " ");
                }
                System.out.println();
            }
            System.exit(0);
            return;
        }

        if (board[i][j] == 0) {
            for (int k = 1; k <= 9; k++) {
                if (possible(i, j, k)) {
                    board[i][j] = k;
                    bt(i, j + 1);
                }
            }
            board[i][j] = 0;
            return;
        }
        bt(i, j + 1);
            
    }

    static boolean possible(int i, int j, int k) {
        for (int l = 0; l < 9; l++) {
            if (board[i][l] == k || board[l][j] == k) return false;
        }
        for (int l = 0; l < 3; l++) {
            for (int m = 0; m < 3; m++) {
                if (board[(i / 3) * 3 + l][(j / 3) * 3 + m] == k) return false;
            }
        }
        return true;
    }
}

