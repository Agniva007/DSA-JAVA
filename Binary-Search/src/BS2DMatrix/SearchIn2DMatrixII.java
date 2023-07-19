package BS2DMatrix;

public class SearchIn2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(matrix, 16));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int i=0, j=m-1;
        if(target == matrix[i][j]) return true;

        while(i<n){
            if(i>=0 && i<n && j>=0 && j<m){
                if(target < matrix[i][j]) j--;
                else if(target > matrix[i][j]) i++;
                else return true;
            }
            else return false;
        }

        return false;
    }
}
