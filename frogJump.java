/*
Problem statement
There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.
For Example
If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.
*/



import java.util.Scanner;

public class frogJump {
    // Memoization or Recursion
    static int jumpOne,jumpTwo;
    public static int minEnergy(int ind,int[] heights) {
        if(ind == 0) return 0;
        jumpOne = Math.abs(heights[ind] - heights[ind - 1]) + minEnergy(ind-1,heights);
        if (ind > 1) {
            jumpTwo = minEnergy(ind - 2, heights) + Math.abs(heights[ind] - heights[ind - 2]);
        }
        return Math.min(jumpOne, jumpTwo);
    }
    // Tabulation
    public static int minEnergy(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        dp[1] = Math.abs(heights[1] - heights[0]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i-1] + Math.abs(heights[i] - heights[i-1]), dp[i-2] + Math.abs(heights[i] - heights[i-2]));
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of test cases: ");
        int t = scanner.nextInt();
        
        for (int k = 0; k < t; k++) {
            System.out.print("Enter the number of stairs: ");
            int n = scanner.nextInt();
            int[] heights = new int[n];
            
            System.out.print("Enter the heights of stairs: ");
            for (int i = 0; i < n; i++) {
                heights[i] = scanner.nextInt();
            }
            
            System.out.println(minEnergy(heights));
        }
        scanner.close();
    }
}
