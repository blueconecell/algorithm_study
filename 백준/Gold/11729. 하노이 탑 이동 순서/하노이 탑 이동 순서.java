import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        sb.append((int) (Math.pow(2, n) - 1)).append("\n");

        Hanoi(n, 1, 2, 3);

        System.out.println(sb);

    }

    static void Hanoi(int n, int first, int second, int third) {
        if (n == 1) {
            sb.append(first + " " + third).append("\n");
            return;
        }
        Hanoi(n - 1, first, third, second);
        sb.append(first + " " + third).append("\n");
        Hanoi(n - 1, second, first, third);
    }

}