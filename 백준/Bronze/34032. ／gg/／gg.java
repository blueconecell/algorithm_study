import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[][] arr;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split("");
        int sum =0;
        boolean ans = false;
        for (int i = 0; i < n; i++) {
            if(in[i].equals("O")){
                sum++;
            }
            if (n / 2 + 1 <= sum) {
                ans = true;
                break;
            }
        }
        if(n%2==0 && n/2<=sum){
            ans=true;
        }
        if(ans){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }

}