import java.util.*;

public class Main {
  static int[] dx = {0,0,1,-1};
  static int[] dy = {1,-1,0,0};
  static int[][] arr, dist;
  static int N,M;
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    M = sc.nextInt();
    N = sc.nextInt();
    sc.nextLine();

    arr = new int[N][M];
    dist = new int[N][M];
    
    for (int i = 0; i < N; i++) {
      Arrays.fill(dist[i],Integer.MAX_VALUE);
      
      String line = sc.nextLine();
      for (int j = 0; j < M; j++) {
        arr[i][j] = Character.getNumericValue(line.charAt(j));
      }
    }
    sc.close();

    dj();
 System.out.println(dist[N - 1][M - 1]);
    

  }

  static void dj(){
    PriorityQueue<Point> pq = new PriorityQueue<>((o1,o2)->o1.cnt-o2.cnt);

    dist[0][0]=0;
    pq.offer(new Point(0,0,0));
    while(!pq.isEmpty()){
      Point cur = pq.poll();
      for(int i=0; i<4; i++){
        int nx = dx[i]+cur.x;
        int ny = dy[i]+cur.y;
        int ncnt = cur.cnt;
        if(nx<0|| ny<0|| nx>=M || ny>=N){
          continue;
        }
        if(arr[ny][nx]==1){
          ncnt++;
        }
        if(dist[ny][nx]>ncnt){
          dist[ny][nx]=ncnt;
          pq.offer(new Point(nx,ny,ncnt));
        }
      }
    }

    
  }

 public static class Point{
    int x,y,cnt;
    public Point(int x, int y, int cnt){
      this.x = x;
      this.y =y;
      this.cnt = cnt;
    }
  }

  
}
 
