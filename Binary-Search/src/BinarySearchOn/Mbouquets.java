package BinarySearchOn;

public class Mbouquets {
    public static void main(String[] args) {
        System.out.println(minDay(new int[]{1,10,3,10,2}, 3, 1));
    }

    public static int minDay(int[] arr, int m, int k){
        long val = (long) m*k;
        int n = arr.length;
        if(val > n) return -1;

        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        int start = mini, end = maxi;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(possible(arr, mid, m, k)){
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }

        return start;
    }

    public static boolean possible(int[] arr, int day, int m, int k){
        int n = arr.length;
        int count = 0;
        int noOfB = 0;
        for(int i=0; i<n; i++){
            if(arr[i] <= day){
                count++;
            }else{
                noOfB += count/k;
                count = 0;
            }
        }

        noOfB += count/k;
        return noOfB>=m;
    }
}
