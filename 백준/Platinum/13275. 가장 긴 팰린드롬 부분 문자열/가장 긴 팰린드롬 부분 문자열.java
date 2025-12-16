
import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] raw = br.readLine().split("");
        String[] s = new String[raw.length * 2 + 1];
        s[0] = "#";
        for (int i = 0; i < raw.length; i++) {
            s[i * 2 + 1] = raw[i];
            s[i * 2 + 2] = "#";
        }

        int N = s.length;
        int[] a = new int[N];
        int r = 0; // 팰랜드롬이 끝나는 인덱스 중 최대값
        int c = 0; // r 값이 최대가 되게 하는 중심 인덱스
        int ans = 0;

        for (int i = 0; i < N; i++) {
            // i가 이전에 구한 회문 영역에 속하는지
            if (i <= r) {
                a[i] = Math.min(r - i, a[2 * c - i]);
            } else {
                a[i] = 0;
            }

            // 회문인지 판단. i 기준으로 좌우 1개씩 범위를 늘려가며 찾기
            while (i - a[i] - 1 >= 0 && i + a[i] + 1 < N && s[i - a[i] - 1].equals(s[i + a[i] + 1])) {
                a[i]++;
            }
            // 이전 팰린드롬 종료 시점보다 새로 생성된 팰린드롬의 종료 시점이 더 뒤
            if (r < i + a[i]) {
                r = i + a[i];
                c = i;
            }
            ans = Math.max(ans, a[i]);
        }
        System.out.println(ans);


    }
}