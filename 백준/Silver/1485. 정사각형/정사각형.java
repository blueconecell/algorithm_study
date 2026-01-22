import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int testCase = 0; testCase < T; testCase++) {
            Point[] s = new Point[4];

            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                s[i] = new Point(x, y);
            }

            // 1. 네 점 사이의 모든 거리(6개)를 구합니다.
            long[] dists = new long[6];
            int count = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    dists[count++] = getDistSq(s[i], s[j]);
                }
            }

            // 2. 거리를 오름차순으로 정렬합니다.
            Arrays.sort(dists);

            // 3. 정사각형 조건 확인:
            // 앞의 4개(변)가 모두 같고, 뒤의 2개(대각선)가 모두 같아야 합니다.
            if (dists[0] == dists[1] && dists[1] == dists[2] && dists[2] == dists[3]
                    && dists[4] == dists[5]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.print(sb);
    }

    // 거리의 제곱을 구하는 메서드 (long 타입 권장)
    static long getDistSq(Point a, Point b) {
        long dx = a.x - b.x;
        long dy = a.y - b.y;
        return dx * dx + dy * dy;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}