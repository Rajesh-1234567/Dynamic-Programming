import java.util.*;

public class frogJumpWithKthDistance {
    // RECURSIVE APPROACH -----------------
    public static int findWay(int index, int[] heights, int k) {
        if (index == 0) return 0;
        int minimumSteps = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int jump = Math.abs(heights[index] - heights[index - i]) + findWay(index - i, heights, k);
                minimumSteps = Math.min(minimumSteps, jump);
            }
        }
        return minimumSteps;
    }

    // TABULATION APPROACH -------------------------
    public static int tabulationApproach(int n, int[] heights, int[] dp, int k) {
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1];
    }

    public static void main(String args[]) {
        // Sample Input 1
        int[] height1 = {2, 5, 2};
        int n1 = 3;
        int k1 = 1;
        System.out.println("Minimum cost for sample input 1: " + findWay(n1 - 1, height1, k1)); // Output: 6

        // Sample Input 2
        int[] height2 = {10, 40, 30, 10};
        int n2 = 4;
        int k2 = 2;
        // For Tabulation approach --------
        int[] dp = new int[n2];
        Arrays.fill(dp, -1);
        System.out.println("Minimum cost for sample input 2: " + tabulationApproach(n2, height2, dp, k2)); // Output: 40
    }
}
