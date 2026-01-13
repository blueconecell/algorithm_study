
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int bb = 10;
        if(b==1000){
            bb *= 1000;
        }else if(b>=100){
            bb *= 100;
        } else if (b >= 10) {
            bb *= 10;
        }
        System.out.println(a + b - c);
        System.out.println(a * bb + b - c);
    }
}