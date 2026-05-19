import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int t = 0;
        int n = players.length;
        Server server = new Server();
        for(int i=0;i<n; i++){
            int cur = players[i];
            // System.out.print(i+" : ");
            // System.out.print(cur+" : ");
            // System.out.print(server.lim(i,m,k)+" : ");
            if(cur >= server.lim(i,m,k)){
                int left = cur - server.lim(i,m,k);
                int[] s = {i,left/m+1};
                answer+=left/m+1;
                server.s.add(s);
                
                // System.out.println(" add "+left/m+1);
            }
            // System.out.println(" \n---- ");
            
        }
        return answer;
    }
}
class Server{
    ArrayList<int[]> s;
    public Server(){
        s = new ArrayList<>();
    }
    public int lim(int cur_time, int m, int k){
        int l=m;
        for(int[] ss : s){
            if(ss[0] + k > cur_time){ 
                l+=ss[1]*m;
            }
        }
        return l;
    }
}