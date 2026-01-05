
import java.util.*;
import java.io.*;

public class Main {
    static int N, M, H, ans;
    static boolean[][] arr;
    static boolean fin;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
        }

        for (int i = 0; i <= 3; i++) {
            ans = i;
            bt(1, 0);
            if (fin) {
                break;
            }
        }
        if(fin){
            System.out.println(ans);
        }else{
            System.out.println(-1);
        }


    }
    static boolean check(){
        for (int i = 1; i <= N; i++) {
            int cur = i;
            for (int h = 1; h <= H; h++) {
                if(arr[h][cur]){
                    cur++;
                }else if(cur>1 && arr[h][cur-1]){
                    cur--;
                }
            }
            if(cur != i)return false;
        }
        return true;
    }

    static void bt(int h, int cnt) {
        if (fin) return;
        if(cnt == ans){
            if (check()) {
                fin = true;
            }
            return;
        }
        for (int i = h; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (!arr[i][j] && !arr[i][j - 1] && !arr[i][j + 1]) { // 추가 사다리 설치 조건
                    arr[i][j] = true;
                    bt(i, cnt + 1);
                    arr[i][j] = false;
                }
            }
        }
    }
}