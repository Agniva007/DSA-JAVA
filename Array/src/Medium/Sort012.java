package Medium;

public class Sort012 {
    public static void main(String[] args) {
        int[] arr = {1,1,2,0,1,0,2,0,2};
        sort012(arr, 9);
        for(int val : arr){
            System.out.println(val);
        }
    }

    public static void sort012(int a[], int n){
        // code here
        int low = 0;
        int mid = 0;
        int high = n-1;
        int temp = 0;
        while(mid<=high){
            if(a[mid]==0){
                temp = a[low];
                a[low] = a[mid];
                a[mid] = temp;
                low++;
                mid++;
                continue;
            }
            if(a[mid]==1){
                mid++;
                continue;
            }
            if(a[mid]==2){
                temp = a[mid];
                a[mid] = a[high];
                a[high] = temp;
                high--;
                continue;
            }
        }

    }
}
