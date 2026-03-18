import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ans = 0;
        for (int i = 0; i < 8; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                if((i+j)%2==0 && input[j].equals("F")){
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
}