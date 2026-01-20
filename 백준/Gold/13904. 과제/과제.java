import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Work> list = new ArrayList<>();
        int maxDay = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new Work(d, v));
            maxDay = Math.max(maxDay, d);
        }

        // 1. 점수 내림차순으로 정렬
        Collections.sort(list, (o1, o2) -> o2.value - o1.value);

        int[] schedule = new int[maxDay + 1];
        int totalScore = 0;

        for (Work cur : list) {
            // 2. 마감일부터 역순으로 빈 날짜가 있는지 확인
            for (int i = cur.deadline; i > 0; i--) {
                if (schedule[i] == 0) {
                    schedule[i] = cur.value;
                    totalScore += cur.value;
                    break;
                }
            }
        }
        System.out.println(totalScore);
    }

    private static class Work {
        int deadline, value;
        public Work(int deadline, int value) {
            this.deadline = deadline;
            this.value = value;
        }
    }
}