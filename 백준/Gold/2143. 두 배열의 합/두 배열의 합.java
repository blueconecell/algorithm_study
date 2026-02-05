import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arrN = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrM = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        int ns = n * (n + 1) / 2;
        int ms = m * (m + 1) / 2;

        long[] sumN = new long[ns];
        long[] sumM = new long[ms];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            long temp = 0;
            for (int j = i; j < n; j++) {
                temp += arrN[j];
                sumN[idx++] = temp;
            }
        }

        idx = 0;
        for (int i = 0; i < m; i++) {
            long temp = 0;
            for (int j = i; j < m; j++) {
                temp += arrM[j];
                sumM[idx++] = temp;
            }
        }

        Arrays.sort(sumN);
        Arrays.sort(sumM);

        long ans = 0;
        int left = 0;
        int right = sumM.length - 1;
        while (left < ns && right >= 0) {
            long lv = sumN[left];
            long rv = sumM[right];
            long s = lv + rv;
            if (s == T) {
                long ansL = 0;
                long ansR = 0;
                while (left < ns && sumN[left] == lv) {
                    ansL++;
                    left++;
                }
                while (right >= 0 && sumM[right] == rv) {
                    ansR++;
                    right--;
                }
                ans += ansL * ansR;
            } else if (s > T) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(ans);
    }
}