package Easy;

public class FindLargestElement {
    public static void main(String[] args) {
        System.out.println(largest(new int[]{2,5,0,1,4}));
    }

    public static int largest(int arr[]) {
        int max= arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max= arr[i];
            }
        }
        return max;
    }
}
