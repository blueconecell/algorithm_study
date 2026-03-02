import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();
                if(map.containsKey(s2)) {
                    map.put(s2, map.get(s2)+1);
                }else{
                    map.put(s2, 1);
                }
            }
            int ans= 1;
            for (String key : map.keySet()) {
                ans *= (map.get(key) + 1);
            }
            System.out.println(ans-1);
        }

    }
}