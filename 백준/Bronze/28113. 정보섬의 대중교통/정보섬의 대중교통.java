import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (b <= n) {
            if (a == n) {
                System.out.println("Anything");
            } else if (a > n) {
                System.out.println("Subway");
            }else{
                System.out.println("Bus");
            }
        }else{
            if(a==b){
                System.out.println("Anything");
            }else if(a>b){
                System.out.println("Subway");
            }else {
                System.out.println("Bus");
            }
        }
    }

}