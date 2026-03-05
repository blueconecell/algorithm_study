import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        a:
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(i==j) continue;
                if(sum-arr[i]-arr[j]==100){
                    for (int k = 0; k < 9; k++) {
                        if(k!=i && k!=j){
                            System.out.println(arr[k]);
                        }
                    }
                    break a;
                }
            }
        }

    }
}