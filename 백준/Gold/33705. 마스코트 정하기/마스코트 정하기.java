import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] presum = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        presum[0] = 0;
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + (arr[i - 1] == 1 ? 1 : -1);
        }

        int total = presum[n];

        // 1. 이미 쿠가 마스코트인 경우 (합이 0 이상)
        if (total >= 0) {
            System.out.println(0);
            return;
        }

        int[] suffixMin = new int[n + 2];
        suffixMin[n + 1] = Integer.MAX_VALUE;
        for (int i = n; i >= 1; i--) {
            suffixMin[i] = Math.min(presum[i], suffixMin[i + 1]);
        }

        // 2. 1번의 행동으로 가능한지 확인
        for (int i = 0; i <= n - 1; i++) {
            int minPresum = suffixMin[i + 1];
            
            // i=0일 때 n번째(마지막)까지 모두 지우는 경우(L=1, R=N)를 방지
            if (i == 0) {
                minPresum = Integer.MAX_VALUE;
                for (int j = 1; j <= n - 1; j++) {
                    minPresum = Math.min(minPresum, presum[j]);
                }
            }

            // 부등호 >= 0 으로 수정
            if (minPresum != Integer.MAX_VALUE && presum[i] - minPresum + total >= 0) {
                System.out.println(1);
                return;
            }
        }

        // 3. 위 조건들을 만족하지 못하면 무조건 2번
        System.out.println(2);
    }
}