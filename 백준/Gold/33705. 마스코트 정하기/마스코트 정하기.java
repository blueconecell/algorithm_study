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

        // 답 0: 이미 전체에서 1번이 과반 이상
        if (total >= 0) {
            System.out.println(0);
            return;
        }

        // 답 1: 연속 구간 하나를 제거하여 조건 달성 가능한지
        // suffixMin[i] = min(presum[i], presum[i+1], ..., presum[n])
        int[] suffixMin = new int[n + 2];
        // suffixMinExcN[i] = min(presum[i], ..., presum[n-1]) (presum[n] 제외)
        int[] suffixMinExcN = new int[n + 2];
        suffixMin[n + 1] = Integer.MAX_VALUE;
        suffixMinExcN[n + 1] = Integer.MAX_VALUE;
        suffixMinExcN[n] = Integer.MAX_VALUE; // presum[n] 제외
        suffixMin[n] = presum[n];
        for (int i = n - 1; i >= 1; i--) {
            suffixMin[i] = Math.min(presum[i], suffixMin[i + 1]);
            suffixMinExcN[i] = Math.min(presum[i], suffixMinExcN[i + 1]);
        }

        for (int i = 0; i <= n - 1; i++) {
            // 제거 구간 [i+1..R], 남은 학생 = i + (n - R) >= 1
            // i >= 1이면 R = n도 가능 -> suffixMin 사용
            // i == 0이면 R <= n-1만 가능 -> suffixMinExcN 사용
            int minVal = (i > 0) ? suffixMin[i + 1] : suffixMinExcN[i + 1];
            if (minVal != Integer.MAX_VALUE
                    && presum[i] - minVal + total >= 0) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(2);
    }
}