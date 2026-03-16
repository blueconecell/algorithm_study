import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("*")) break;

            boolean[] p = new boolean[26];
            for (char c : str.toCharArray()) {
                if(c==' ') continue;
                p[c - 'a'] = true;
            }
            boolean ans = true;
            for (int i = 0; i < 26; i++) {
                if (!p[i]) {
                    ans = false;
                    break;
                }
            }

            sb.append(ans ? "Y" : "N").append("\n");
        }
        System.out.println(sb);
    }
}