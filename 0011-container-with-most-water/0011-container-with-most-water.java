import java.util.*;

class Solution {
    public int maxArea(int[] h) {
        int ans = 0;
        int n = h.length;

        int left = 0;
        int right = n-1;
        while(left<right){
            ans = Math.max(ans, (right-left) * Math.min(h[left],h[right]));
            if(h[left] < h[right]){
                left++;
            }else{
                right--;
            }
        }



        // for(int i=0; i<n; i++){
        //     for(int j=n-1;j>=0; j--){
        //         if(i>=j)break;
        //         int h = Math.min(height[i],height[j]);
        //         ans = Math.max(h*(j-i),ans);

        //     }
        // }





        return ans;
        
    }
}