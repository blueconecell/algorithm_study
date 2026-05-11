import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int max_alp = 0;
        int max_cop = 0;

        // 1. 목표치(도착 노드) 설정
        for (int[] p : problems) {
            max_alp = Math.max(max_alp, p[0]);
            max_cop = Math.max(max_cop, p[1]);
        }

        // 초기 능력치가 이미 목표치 이상일 수 있으므로 보정
        alp = Math.min(alp, max_alp);
        cop = Math.min(cop, max_cop);

        // 2. 최단 거리(시간) 배열 초기화
        int[][] dist = new int[max_alp + 2][max_cop + 2];
        for (int i = 0; i <= max_alp + 1; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // 3. 우선순위 큐 생성: int[]{누적 시간, 현재 알고력, 현재 코딩력}
        // 시간이 적게 걸리는 경로를 먼저 탐색하도록 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        dist[alp][cop] = 0;
        pq.offer(new int[]{0, alp, cop});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int curAlp = curr[1];
            int curCop = curr[2];

            // 이미 더 짧은 시간으로 해당 능력치에 도달한 적이 있다면 스킵
            if (dist[curAlp][curCop] < cost) continue;

            // 목표 능력치에 도달했다면 종료 
            // (PQ 특성상 가장 먼저 목표에 도달한 것이 최단 시간임이 보장됨)
            if (curAlp == max_alp && curCop == max_cop) {
                return cost;
            }

            // 4. 간선 탐색 (상태 전이)
            // 4-1. 알고리즘 공부하기
            int nextAlp = Math.min(max_alp, curAlp + 1);
            if (cost + 1 < dist[nextAlp][curCop]) {
                dist[nextAlp][curCop] = cost + 1;
                pq.offer(new int[]{cost + 1, nextAlp, curCop});
            }

            // 4-2. 코딩 공부하기
            int nextCop = Math.min(max_cop, curCop + 1);
            if (cost + 1 < dist[curAlp][nextCop]) {
                dist[curAlp][nextCop] = cost + 1;
                pq.offer(new int[]{cost + 1, curAlp, nextCop});
            }

            // 4-3. 문제 풀기
            for (int[] p : problems) {
                int reqAlp = p[0], reqCop = p[1];
                int rwdAlp = p[2], rwdCop = p[3], pCost = p[4];

                // 현재 능력치로 이 문제를 풀 수 있다면
                if (curAlp >= reqAlp && curCop >= reqCop) {
                    // 능력치가 목표치를 초과하지 않도록 보정
                    nextAlp = Math.min(max_alp, curAlp + rwdAlp);
                    nextCop = Math.min(max_cop, curCop + rwdCop);

                    if (cost + pCost < dist[nextAlp][nextCop]) {
                        dist[nextAlp][nextCop] = cost + pCost;
                        pq.offer(new int[]{cost + pCost, nextAlp, nextCop});
                    }
                }
            }
        }

        return dist[max_alp][max_cop];
    }
}