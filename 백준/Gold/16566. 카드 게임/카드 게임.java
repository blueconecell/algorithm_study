
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] deck = new int[M];
        boolean[] visited = new boolean[M];
        int[] cheolsoo = new int[K];
        int[] minsu = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            deck[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(deck);

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            cheolsoo[i] = Integer.parseInt(st.nextToken());
            int idx = Arrays.binarySearch(deck, cheolsoo[i]);
            if(idx<0){
                idx = idx*-1 -1;
            }else{
                idx++;
            }

            while (visited[idx]) {
                idx++;
            }
            visited[idx] = true;
            sb.append(deck[idx]).append("\n");
        }
        System.out.println(sb);
    }
}