import java.util.*;
class Solution {
    int[] p ;
    
    public void init(int n){
        p = new int[n];
        for(int i=0; i<n; i++){
            p[i] = i;
        }
    }
    public int find(int a){
        if(p[a] == a)return a;
        return p[a] = find(p[a]);
    }
    public boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb)return false;
        if(a>b){
            p[pb] = find(a);
        }else{
            p[pb] = find(b);
        }
        return true;
    }
    
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        init(n);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j]==1 && i!=j){
                    union(i, j);
                }
            }
        }
        HashSet<Integer> s = new HashSet<>();
        System.out.println(Arrays.toString(p));
        for(int i=0; i<n; i++){
            int temp = find(i);
            System.out.println("i : "+i+" temp : "+p[i]);
            if(!s.contains(temp)){
                s.add(temp);
                answer++;
            }
        }
        
        return answer;
    }
}