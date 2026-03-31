import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ans = 0;
        int maxAbs = Math.max(Math.abs(arr[0]), Math.abs(arr[N - 1]));

        for (int i = 0; i < N && arr[i] < 0; i += M) {
            ans += Math.abs(arr[i]) * 2;
        }

        for (int i = N - 1; i >= 0 && arr[i] > 0; i -= M) {
            ans += arr[i] * 2;
        }

        ans -= maxAbs;

        System.out.println(ans);
    }
}