import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean isOdd = false;
        String[] isbn = br.readLine().split("");
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            if (i % 2 == 0) {
                if (isbn[i].equals("*")) {
                    isOdd = true;
                } else {
                    sum += Integer.parseInt(isbn[i]);
                }
            } else {
                if (isbn[i].equals("*")) {
                    isOdd = false;
                } else {
                    sum += Integer.parseInt(isbn[i]) * 3;
                }
            }
        }
        int last = Integer.parseInt(isbn[12]);
        for (int i = 0; i <= 9; i++) {
            if (isOdd) {
                if ((sum + i + last) % 10 == 0) {
                    System.out.println(i);
                    break;
                }
            } else {
                if ((sum + i * 3+last) % 10 == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}