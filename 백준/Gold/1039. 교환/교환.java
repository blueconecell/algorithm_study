import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        String[] str_a = Integer.toString(a).split("");
        int m = str_a.length;
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(str_a[i]);
        }
        boolean[][] visited = new boolean[1_000_001][k + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{a,0});
        visited[a][0] = true;
        int ans = -1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int step = cur[1];
            if (step == k) {
                ans = Math.max(ans, num);
                continue;
            }

            // num으로부터 매번 digits 배열 생성
            char[] digits = String.valueOf(num).toCharArray();

            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    if (i == 0 && digits[j] == '0') continue;

                    char tmp = digits[i];
                    digits[i] = digits[j];
                    digits[j] = tmp;

                    int next = Integer.parseInt(new String(digits));

                    if (!visited[next][step + 1]) {
                        visited[next][step + 1] = true;
                        queue.offer(new int[]{next, step + 1});
                    }

                    // 되돌리기
                    digits[j] = digits[i];
                    digits[i] = tmp;
                }
            }
        }
        System.out.println(ans);

    }
}