package BinarySearchOn;

// TC --> O(N * log(max(a[])))

public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);
        while(low<=high){
            int mid = low + (high-low)/2;
            int totalH = findTotalHour(piles, mid);
            if(totalH <= h){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return low;
    }

    public static int findTotalHour(int[] piles, int hour){
        int totalH = 0;
        for(int i=0; i<piles.length; i++){
            totalH += Math.ceil((double) piles[i]/(double) hour);
        }

        return totalH;
    }

    public static int findMax(int[] piles){
        int max = 0;
        for(int i=0; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }

        return max;
    }
}
