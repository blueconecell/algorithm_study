import java.util.*;
import java.io.*;

public class Main {
    static String minsik = "a b k d e g h i l m n ng o p r s t u w y";
    static List<String> order = Arrays.asList(minsik.split(" "));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }
        words.sort((s1, s2) -> {
            List<String> l1 = tokenize(s1);
            List<String> l2 = tokenize(s2);

            int len = Math.min(l1.size(), l2.size());
            for (int i = 0; i < len; i++) {
                int o1 = order.indexOf(l1.get(i));
                int o2 = order.indexOf(l2.get(i));
                if (o1 != o2) return o1 - o2;
            }
            return l1.size() - l2.size();
        });
        for(String s : words) {
            System.out.println(s);
        }

    }

    static List<String> tokenize(String raw) {
        String[] input = raw.split("");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (i < input.length - 1 && input[i].equals("n") && input[i + 1].equals("g")) {
                result.add("ng");
                i++;
            } else {
                result.add(input[i]);
            }
        }
        return result;
    }
}