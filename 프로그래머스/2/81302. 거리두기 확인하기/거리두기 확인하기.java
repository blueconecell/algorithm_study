import java.util.*;
class Solution {
    int[] di = {0,0,1,-1};
    int[] dj = {1,-1,0,0};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int p =0; p<5; p++){
            String[][] room = new String[5][5];
            for(int i=0;i<5;i++){
                String[] ps = places[p][i].split("");
                for(int j=0;j<5;j++){
                    room[i][j]=ps[j];
                }
            }
            
            boolean flag = true;
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(room[i][j].equals("P")){
                        if(search(i,j,room))flag = false;
                    }
                    if(!flag)break;
                }
                if(!flag)break;
            }
            if(flag){
                answer[p]=1;
            }else{
                answer[p]=0;
            }
        }
        
        
        return answer;
    }
    boolean search(int i,int j,String[][] room){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        q.offer(new int[]{i,j,0});
        visited[i][j]=true;
        while(!q.isEmpty()){
            int [] cur = q.poll();
            // System.out.println(Arrays.toString(cur));
            if(cur[2] >= 2)continue;
            for(int x = 0; x<4; x++){
                int ni = di[x]+cur[0];
                int nj = dj[x]+cur[1];
                if(ni<0||nj<0||ni>=5||nj>=5||visited[ni][nj]||room[ni][nj].equals("X")){
                    continue;
                }
                if(room[ni][nj].equals("P"))return true;
                q.offer(new int[]{ni,nj,cur[2]+1});
                
            }
        }

        return false;
    }
}