package BS2DMatrix;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(arr, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int index = -1;
        for(int i=0; i<n; i++){
            if(matrix[i][m-1] >= target){
                index = binarySearch(matrix[i], 0, m-1, target);
                break;
            }
        }

        return (index!=-1);
    }

    public static int binarySearch(int[] arr, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid] > target){
                return binarySearch(arr, start, mid-1, target);
            }else{
                return binarySearch(arr, mid+1, end, target);
            }
        }

        return -1;
    }
}
