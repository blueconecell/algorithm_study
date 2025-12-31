
import java.util.*;
import java.io.*;

public class Main {

    static HashMap<String, String> p;
    static HashMap<String, Integer> count;

    static void init(String name) {
        if (!p.containsKey(name)) {
            p.put(name, name);
            count.put(name, 1);
        }
    }

    static String find(String name) {
        if (p.get(name).equals(name)) {
            return name;
        }

        p.put(name, find(p.get(name)));
        return p.get(name);
    }

    static int union(String a, String b) {
        String pa = find(a);
        String pb = find(b);

        if (pa.equals(pb)) {
            return Math.max(count.get(pa), count.get(pb));
        }
        int sum = count.get(pa) + count.get(pb);
        count.replace(pa, sum);
        p.replace(pb, pa);
        return Math.max(count.get(pa), count.get(pb));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            p = new HashMap<>();
            count = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();
                init(f1);
                init(f2);
                sb.append(union(f1, f2)).append("\n");
            }
        }
        System.out.println(sb);
    }
}