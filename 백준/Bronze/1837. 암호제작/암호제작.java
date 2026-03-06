import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger p = new BigInteger(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int r = 0;
        for (int i = 2; i < k; i++) {
            if (p.remainder(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                r = i;
                break;
            }
        }

        if (r == 0) {
            System.out.println("GOOD");
        } else {
            System.out.println("BAD " + r);
        }
    }
}