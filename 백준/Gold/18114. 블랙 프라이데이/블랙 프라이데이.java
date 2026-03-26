import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        if(Arrays.binarySearch(arr,c)>=0){
            System.out.println(1);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(arr[i]>c)break;
            int temp = c-arr[i];
            int rest = Arrays.binarySearch(arr,temp);
            if(rest>=0&&arr[rest]!=arr[i]){
                System.out.println(1);
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            if(arr[i]>c)break;
            for (int j = i+1; j < n; j++) {
                if(arr[j]==arr[i]){continue;}
                if(arr[i]+arr[j]>c)break;
                int temp = c-arr[i]-arr[j];
                int rest = Arrays.binarySearch(arr,temp);
                if(rest>=0 && arr[rest]!=arr[i] && arr[rest]!=arr[j]){
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}