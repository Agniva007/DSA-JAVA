package Medium;

import java.util.ArrayList;
import java.util.List;

public class RearrangeArrayElements {
    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};
        rearrangeArray(arr);
        for(int val : arr){
            System.out.print(val + " ");
        }
    }

    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(nums[i]>=0){
                list1.add(nums[i]);
            }else{
                list2.add(nums[i]);
            }
        }

        int i=0, j=0, k=0;
        while(i<list1.size() && j<list2.size()){
            nums[k] = list1.get(i);
            i++;
            nums[k+1] = list2.get(j);
            j++;
            k+=2;
        }

        while(i<list1.size()){
            nums[k++] = list1.get(i++);
        }

        while(j<list2.size()){
            nums[k++] = list2.get(j++);
        }

        return nums;
    }
}
