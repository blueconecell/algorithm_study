import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int n = N;
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if(n<i){
                break;
            }
            while (n % i == 0) {
                n/=i;
                sb.append(i).append("\n");
            }

        }
        System.out.println(sb);
    }
}