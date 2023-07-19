package WEEK1;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,4,6,7,8,10};
        int n = arr.length;
        int low = 0;
        int high = n-1;


        System.out.println(recursiveBS(arr, low, high, 8));
        System.out.println(bs(arr, low, high, 8));
    }

    public static int bs(int[] arr, int l, int h, int k){
        while(l<=h){
            int mid = l + (h-l)/2;
            if(arr[mid]==k) return mid;
            if(arr[mid]<k) l = mid+1;
            else h = mid-1;
        }

        return -1;
    }

    public static int recursiveBS(int[] arr, int l, int h, int k){
        if(l<=h){
            int mid = l + (h-l)/2;
            if(arr[mid]==k) return mid;
            if(arr[mid]<k) return bs(arr, mid+1, h, k);
            else return bs(arr, l, mid-1, k);
        }

        return -1;
    }


}
