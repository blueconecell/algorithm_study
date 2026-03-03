import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] prev = new int[1000001];
    static int[] next = new int[1000001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int cur = input[i];
            int left = input[(i - 1 + N) % N]; // 이전 역 (인덱스 순환)
            int right = input[(i + 1) % N];    // 다음 역 (인덱스 순환)

            prev[cur] = left;
            next[cur] = right;
        }

        // 명령어 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            int iNode = Integer.parseInt(st.nextToken());
            int jNode;
            switch (com) {
                case "BN":
                    jNode = Integer.parseInt(st.nextToken());
                    bn(iNode, jNode);
                    break;
                case "BP":
                    jNode = Integer.parseInt(st.nextToken());
                    bp(iNode, jNode);
                    break;
                case "CN":
                    cn(iNode);
                    break;
                case "CP":
                    cp(iNode);
                    break;
            }
        }
        System.out.print(sb);
    }

    // BN: i 다음(next)에 j 삽입
    static void bn(int i, int j) {
        sb.append(next[i]).append("\n"); // 원래 i의 다음 역 출력

        int originalNext = next[i];

        // j의 연결 관계 설정
        prev[j] = i;
        next[j] = originalNext;

        // i와 originalNext의 연결 관계 갱신
        next[i] = j;
        prev[originalNext] = j;
    }

    // BP: i 이전(prev)에 j 삽입
    static void bp(int i, int j) {
        sb.append(prev[i]).append("\n"); // 원래 i의 이전 역 출력

        int originalPrev = prev[i];

        // j의 연결 관계 설정
        prev[j] = originalPrev;
        next[j] = i;

        // i와 originalPrev의 연결 관계 갱신
        prev[i] = j;
        next[originalPrev] = j;
    }

    // CN: i 다음 역 삭제
    static void cn(int i) {
        int target = next[i]; // 삭제될 역
        sb.append(target).append("\n");

        int newNext = next[target]; // 삭제될 역의 다음 역

        // 건너뛰기 연결
        next[i] = newNext;
        prev[newNext] = i;

        // (선택) 삭제된 역 정보 초기화 - 필수는 아니지만 안전을 위해
        // prev[target] = 0; next[target] = 0;
    }

    // CP: i 이전 역 삭제
    static void cp(int i) {
        int target = prev[i]; // 삭제될 역
        sb.append(target).append("\n");

        int newPrev = prev[target]; // 삭제될 역의 이전 역

        // 건너뛰기 연결
        prev[i] = newPrev;
        next[newPrev] = i;
    }
}