package DpOnSubsequence;

import java.util.Arrays;

public class TargetSum {
    static int total = 0;
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        int n = nums.length;

        for(int val : nums) total += val;

        int[][] dp = new int[nums.length][2 * total + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(rec(nums, 0, 0, target));
        System.out.println(memo(nums, 0, 0, target, dp));
    }

    public static int rec(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int add = rec(nums, i + 1, sum + nums[i], target);
        int subtract = rec(nums, i + 1, sum - nums[i], target);
        return add + subtract;
    }

    public static int memo(int[] nums, int i, int sum, int target, int[][] dp) {
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[i][sum + total] != -1) {
            return dp[i][sum + total];
        }
        int add = memo(nums, i + 1, sum + nums[i], target, dp);
        int subtract = memo(nums, i + 1, sum - nums[i], target, dp);
        return dp[i][sum + total] = add + subtract;
    }
}
