
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int t_ans = 0;
        for (int i = 0; i < 6; i++) {
            t_ans += arr[i] / t;
            if (arr[i] % t > 0) {
                t_ans++;
            }
        }
        System.out.println(t_ans);
        System.out.println(N / p + " " + N % p);

    }
}