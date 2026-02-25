import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sqrt =(int) Math.sqrt(N);
        int pow = sqrt*sqrt;

        int i = 0;
        for (i=0; i < sqrt; i++) {
            if(pow>= N){
                break;
            }
            pow+=sqrt;
        }

        if(N<=4){
            System.out.println(4);
        }else{
            System.out.println(2*(sqrt-1+sqrt+i-1));
        }
    }
}