import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> jobs = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            jobs.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            jobs.get(b).add(a);
        }
        int x = Integer.parseInt(br.readLine());

        int cnt = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        for (int before : jobs.get(x)) {
            queue.add(before);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if(visited[cur]){
                continue;
            }
            visited[cur] = true;
            cnt++;
            for (int before : jobs.get(cur)) {
                if(!visited[before]){
                    queue.offer(before);

                }
            }

        }
        System.out.println(cnt);
    }
}