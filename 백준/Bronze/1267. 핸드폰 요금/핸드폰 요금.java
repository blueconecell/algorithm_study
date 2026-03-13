import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = 0;
        int m = 0;

        for (int i = 0; i < n; i++) {
            int call = Integer.parseInt(st.nextToken())+1;
            y += call % 30 > 0 ? (call / 30 + 1) * 10 : (call / 30) * 10;
            m += call % 60 > 0 ? (call / 60 + 1) * 15 : (call / 60) * 15;
        }
        if (y == m) {
            System.out.println("Y M " + y);
        } else if (y < m) {
            System.out.println("Y " + y);
        } else {
            System.out.println("M " + m);
        }
    }
}