
import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int a = Math.round(n * 0.15f);
        int sum = 0;
        for (int i = a; i < n-a; i++) {
            sum += arr[i];
        }
        System.out.println(Math.round((float) sum / (n - a - a)));


    }
}