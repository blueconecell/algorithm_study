import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N: 종이의 개수, M: 보이기 위한 최대 종이 개수
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 100x100 격자판 (1부터 100까지 사용하기 위해 101로 선언)
        int[][] grid = new int[101][101];

        // 종이 놓기
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            // 입력받은 범위 (x1, y1) ~ (x2, y2)를 1씩 증가
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    grid[x][y]++;
                }
            }
        }

        // M개를 초과하여 가려진 칸 세기
        int invisibleCount = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (grid[i][j] > m) {
                    invisibleCount++;
                }
            }
        }

        System.out.println(invisibleCount);
        sc.close();
    }
}