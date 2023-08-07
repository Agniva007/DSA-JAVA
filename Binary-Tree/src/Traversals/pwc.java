package Traversals;

import java.util.*;

public class pwc {
    public static void main(String[] args) {
        int[] ans = UniqueNumbers(new int[]{1,2,2,3,2,2,5,5});
        for(int val : ans){
            System.out.print(val + " ");
        }
    }

    public static List<Integer> f(int[] nums, List<Integer> ans){
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.add(entry.getValue());
        }

        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            ans.add(nums[list.get(i)]);
        }

        return ans;

    }

    private static int[] UniqueNumbers(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int[] arr = new int[set.size()];
        int ind = set.size()-1;

        for (int i = nums.length - 1; i>= 0; i--) {
            if (!map.containsKey(nums[i])) {
                arr[ind--] = nums[i];
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return arr;
    }
}
