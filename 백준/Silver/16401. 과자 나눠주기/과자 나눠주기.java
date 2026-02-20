import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 1;
        int right = arr[M - 1];
        int ans=0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid)) {
                ans = mid;
                left = mid+1;

            }else{
                right = mid-1;
            }
        }
        System.out.println(ans);

    }

    static boolean isPossible(int mid) {
        int cnt = 0;
        for (int i = M - 1; i >= 0; i--) {
            if (arr[i] >= mid && cnt <= N) {
                cnt += arr[i] / mid;
            } else {
                break;
            }
        }
        if (cnt >= N) {
            return true;
        }
        return false;
    }

}