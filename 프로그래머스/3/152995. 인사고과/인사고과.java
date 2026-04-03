import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int wanhoA = scores[0][0];
        int wanhoB = scores[0][1];
        int wanhoSum = wanhoA + wanhoB;
        
        // a 내림차순, a가 같으면 b 오름차순
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });

        int maxB = 0;
        int rank = 1; // 기본 등수는 1등

        for (int[] score : scores) {
            // maxB보다 작으면 앞에 두 점수가 모두 높은 사람이 있다는 뜻 (탈락)
            if (score[1] < maxB) {
                // 탈락한 사람이 완호라면 -1 반환
                if (score[0] == wanhoA && score[1] == wanhoB) {
                    return -1;
                }
            } else {
                // 인센티브 대상자
                maxB = score[1];
                // 점수 합이 완호보다 높으면 완호의 등수 하락
                if (score[0] + score[1] > wanhoSum) {
                    rank++;
                }
            }
        }
        
        return rank;
    }
}