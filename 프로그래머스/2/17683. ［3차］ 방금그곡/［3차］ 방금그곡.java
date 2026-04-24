import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String[] listenedMusic = getContent(m);
        Music ans = null;
        int n = musicinfos.length;

        for (int mi = 0; mi < n; mi++) {
            Music cur = new Music(mi, musicinfos[mi]);
            // System.out.println(cur.title + cur.length);
            // if(ans!=null)            System.out.println(ans.title + ans.length);
            if (ans != null && cur.length < ans.length) continue;

            int curN = cur.content.length;
            boolean found = false;


            // 시작 위치를 하나씩 옮기며 전체 탐색
            for (int start = 0; start < curN; start++) {
                if (!listenedMusic[0].equals(cur.content[start])) continue;
                boolean same = true;
                for (int i = 0; i < listenedMusic.length; i++) {
                    int idx = start + i;  
                    if (idx >= curN) { same = false; break; }
                    if (!listenedMusic[i].equals(cur.content[idx])) {
                        same = false;
                        break;
                    }
                }
                if (same) { found = true; break; }
            }

            if (!found) continue;
            if (ans == null || cur.length > ans.length || 
                (cur.length == ans.length && cur.idx < ans.idx)) {
                ans = cur;
            }
        }

        return ans == null ? "(None)" : ans.title;
    }

    public String[] getContent(String raw) {
        String[] rs = raw.split("");
        List<String> l = new ArrayList<>();
        for (int i = 0; i < rs.length; i++) {
            if (i + 1 < rs.length && rs[i + 1].equals("#")) {
                l.add(rs[i] + "#");
                i++;
            } else if (!rs[i].equals("#")) {
                l.add(rs[i]);
            }
        }
        return l.toArray(new String[0]);
    }

    class Music {
        int idx, length;
        String title;
        String[] content;

        public Music(int idx, String raw) {
            this.idx = idx;
            String[] s = raw.split(",");
            this.length = getLength(s[0], s[1]);
            this.title = s[2];

            // content를 length 길이만큼 반복 확장
            String[] base = getContent(s[3]);
            String[] expanded = new String[length];
            for (int i = 0; i < length; i++) {
                expanded[i] = base[i % base.length];
            }
            this.content = expanded;
        }

        private int getLength(String s1, String s2) {
            String[] t1 = s1.split(":");
            String[] t2 = s2.split(":");
            return (Integer.parseInt(t2[0]) - Integer.parseInt(t1[0])) * 60
                 + (Integer.parseInt(t2[1]) - Integer.parseInt(t1[1]));
        }
    }
}


/*
입력값 〉 "CDCDCD", ["12:00,12:10,NAME,CDCDCDE", "12:30,12:50,NA,CD"]
기댓값 〉 "NA"
*/