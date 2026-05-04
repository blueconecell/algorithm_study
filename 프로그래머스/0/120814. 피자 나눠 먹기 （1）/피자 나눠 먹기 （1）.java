class Solution {
    public int solution(int n) {
        int answer = 0;
        while(true){
        if(answer*7>=n){
            return answer;
        }else{
            answer++;
        }
        }
    }
}