package BinarySearchOn;

import java.util.Arrays;

public class AggresiveCows {
    public static void main(String[] args) {
        System.out.println(aggressive(new int[]{0, 3, 7, 4, 10, 9}, 4)); // it return max(min)
    }

    public static int aggressive(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1;
        int high = stalls[n-1]-stalls[0]; // because atleast 2 cows will be there and we have to find their max distance b/w them

        while(low<=high){
            int mid = low + (high-low)/2;
            if(canPlace(stalls, mid, k)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return high;
    }

    public static boolean canPlace(int[] arr, int dist, int cows){
        int n = arr.length;
        int countCows = 1;
        int last = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i]-last >= dist){
                countCows++;
                last = arr[i];
            }
            if(countCows>=cows) return true;
        }

        return false;
    }
}
