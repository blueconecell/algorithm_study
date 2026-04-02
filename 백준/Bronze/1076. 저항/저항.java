import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("black", 0);
        hm.put("brown", 1);
        hm.put("red", 2);
        hm.put("orange", 3);
        hm.put("yellow", 4);
        hm.put("green", 5);
        hm.put("blue", 6);
        hm.put("violet", 7);
        hm.put("grey", 8);
        hm.put("white", 9);

        long ans = (long) ((hm.get(a) * 10 + hm.get(b)) * Math.pow(10, hm.get(c)));
        System.out.println(ans);

    }
}