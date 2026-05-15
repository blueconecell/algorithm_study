class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        int n = numbers.length;
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=numbers[i];
        }
        answer = (double) sum/n;
        System.out.println(sum/n);
        return answer;
    }
}