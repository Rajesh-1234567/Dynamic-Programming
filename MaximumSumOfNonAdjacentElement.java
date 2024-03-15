import java.util.*;
//  APPROACH ------------------ Pick and Non Pick technique
public class MaximumSumOfNonAdjacentElement {
    // RECURSION APPROACH -----------------------
    public static int maximumSum(int index, ArrayList<Integer> nums) {
        if (index == 0) return nums.get(index);
        if (index < 0) return 0;
        int pick = nums.get(index) + maximumSum(index - 2, nums);
        int notPick = 0 + maximumSum(index - 1, nums);
        return Math.max(pick, notPick);
    }

    // MEMOIZATION APPROACH --------------------
    public static int maximumSumMemoization(int index, ArrayList<Integer> nums, int[] dp) {
        if (index == 0) return nums.get(index);
        if (index < 0) return 0;
        if (dp[index] != -1) return dp[index];
        int pick = nums.get(index) + maximumSumMemoization(index - 2, nums, dp);
        int notPick = 0 + maximumSumMemoization(index - 1, nums, dp);
        return dp[index] = Math.max(pick, notPick);
    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maximumSumMemoization(n - 1, nums, dp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(3, 2, 7, 10));
        System.out.println("Maximum sum of non-adjacent elements: " + maximumNonAdjacentSum(nums));
    }
}
