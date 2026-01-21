import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Problem[] problems = new Problem[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            problems[i] = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(problems, (o1, o2) -> o1.deadline - o2.deadline);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;

        for (Problem p : problems) {
            pq.add(p.value);
            if (pq.size() > p.deadline) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        System.out.println(ans);
    }

    private static class Problem {
        int deadline, value;

        public Problem(int deadline, int value) {
            this.deadline = deadline;
            this.value = value;
        }
    }
}