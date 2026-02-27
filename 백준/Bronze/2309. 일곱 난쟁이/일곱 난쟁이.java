import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        boolean[] visited = new boolean[9];
        int total = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }
        Arrays.sort(arr);
        boolean end = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) {
                    continue;
                }
                if (total - arr[i] - arr[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            System.out.println(arr[k]);
                        }
                    }
                    end = true;
                    break;
                }
            }
            if(end)break;
        }
    }


}