import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[][] arr;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new String[n*5][n*5];
        for (int i = 0; i < n * 5; i++) {
            for (int j = 0; j < n * 5; j++) {

                if (i < n || i > n * 5 - n - 1) {
                    arr[i][j] = "@";
                } else if (j < n) {
                    arr[i][j] = "@";
                }else{
                    arr[i][j] = "";
                }
            }
        }
        for (int i = 0; i < n * 5; i++) {
            for (int j = 0; j < n * 5; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    }

}