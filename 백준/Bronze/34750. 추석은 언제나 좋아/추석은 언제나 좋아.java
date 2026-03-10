import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n >= 1_000_000) {
            System.out.println((int)(n*0.20)+" "+(int)(n*0.80));
        } else if (n >= 500_000) {
            System.out.println((int)(n*0.15)+" "+(int)(n*0.85));
        } else if (n >= 100_000) {
            System.out.println((int)(n*0.10)+" "+(int)(n*0.90));
        }else{
            System.out.println((int)(n*0.05)+" "+(int)(n*0.95));
        }
    }

}