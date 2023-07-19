package BinarySearchOn;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
// TC --> O(N * log(sum(weights[]) – max(weights[]) + 1)) , SC --> O(1)

public class CapacityToShip {
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
    }

    public static int shipWithinDays(int[] weights, int days){
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0; i<weights.length; i++){
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while(low<=high){
            int mid = low + (high-low)/2;

            if(findDays(weights, mid) <= days){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return low;
    }

    public static int findDays(int[] arr, int capacity){
        int days = 1;
        int load = 0;
        for(int i=0; i<arr.length; i++){
            if(load + arr[i] > capacity){
                days += 1;
                load = arr[i];
            }else{
                load += arr[i];
            }
        }

        return days;
    }
}
