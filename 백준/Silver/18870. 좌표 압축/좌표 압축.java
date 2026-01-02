
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int inn = Integer.parseInt(st.nextToken());
            arr[i] = inn;
            set.add(inn);
        }
        ArrayList<Integer> l = new ArrayList<>(set);
        Collections.sort(l);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < l.size(); i++) {
            map.put(l.get(i), i );
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr[i]).toString() + " ");
        }
        System.out.println(sb);
    }
}