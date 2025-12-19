import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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

        // 반지름 길이 저장
        int[] a = new int[N];

        // 회문 종료 지점 인덱스 위치 저장(최대값저장함)
        int r = 0;

        // 회문의 반지름 값이 최대가 될 경우의 중심점 인덱스
        int c = 0;

        for (int i = 0; i < N; i++) {
            // i 값이 회문 종료 지점 이전에 있는 경우 -> 회문에 포함되어 건너뛰기
            if (i <= r) {
                a[i] = Math.min(r - i, a[2 * c - i]);
            } else {
                a[i] = 0;
            }

            // 회문인지 판단하기
            while (i - a[i] - 1 >= 0 && i + a[i] + 1 < N && s[i - a[i] - 1].equals(s[i + a[i] + 1])) {
                a[i]++;
            }

            // 현재 회문의 종료 지점이 더 뒤인 경우
            if (r < i + a[i]) {
                r = i + a[i];
                c = i;
            }
        }
        long ans = 0;
        for (int i : a) {
            ans += i;
        }
        // 자기자신도 회문으로 포함하기
        ans += raw.length;

        // 홀수화를 위해 dummy 문자열 넣은것 제거하기
        ans /= 2;

        System.out.println(ans);

    }
}