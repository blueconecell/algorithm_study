import java.util.*;

class Solution {
    static HashMap<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        map = new HashMap<>();
        
        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            for (int c : course) {
                combine(sorted, c, 0, new StringBuilder());
            }
        }
        
        for (int c : course) {
            int max = 0;
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (e.getKey().length() == c) {
                    max = Math.max(max, e.getValue());
                }
            }
            if (max >= 2) {
                for (Map.Entry<String, Integer> e : map.entrySet()) {
                    if (e.getKey().length() == c && e.getValue() == max) {
                        answer.add(e.getKey());
                    }
                }
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    static void combine(String order, int depth, int start, StringBuilder sb) {
        if (sb.length() == depth) {
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }
        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            combine(order, depth, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}