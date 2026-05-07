import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            Integer cur = hm.get(nums[i]);
            if(cur==null){
                hm.put(nums[i],1);
            }else{
                hm.put(nums[i],cur+1);
            }
        }
        int idx = n/2;
        for(Integer i: hm.keySet()){
            if(idx==0)break;
            idx--;
            answer++;
        }
        
        return answer;
    }
}