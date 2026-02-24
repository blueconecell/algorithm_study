import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = br.readLine();
        }
        String ans = "";
        for (int i = 0; i < 3; i++) {
            try{
                int a = Integer.parseInt(arr[i]);
                a = a+3-i;
                if (a % 3 == 0 && a % 5 == 0) {
                    ans = "FizzBuzz";
                } else if (a % 3 == 0) {
                    ans = "Fizz";
                }else if (a % 5 == 0) {
                    ans = "Buzz";
                }else{
                    ans = Integer.toString(a);
                }
                break;
            }catch(Exception e){
            }
        }
        System.out.println(ans);
    }
}