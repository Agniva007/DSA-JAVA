package Easy;

public class SecondLargestElement {
    public static void main(String[] args) {
        System.out.println(largest(new int[]{2,5,0,4,1}, 5));
    }

    private static int largest(int[] arr, int n){
        if(n<2)
            return -1;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;
        int i;
        for (i = 0; i < n; i++)
        {
            if (arr[i] > large)
            {
                second_large = large;
                large = arr[i];
            }

            else if (arr[i] > second_large && arr[i] != large)
            {
                second_large = arr[i];
            }
        }
        return second_large;
    }
}
