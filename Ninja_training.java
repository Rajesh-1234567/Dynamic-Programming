import java.util.*;

public class Ninja_training {
    // RECURSION ------------------------------------------------------------------
    public static int solve(int day, int [][]arr,int last){
        if(day==0){
            int max =0;
            for(int i=0;i<=2;i++){
                if(i != last){
                    max = Math.max(max,arr[0][i]);
                }
            }
            return max;
        }
        int max =0;
        for(int i=0;i<=2;i++){
                if(i != last){
                    int findMax = arr[day][i] + solve(day-1,arr,i);
                    max = Math.max(max,findMax);
                }
            }
            return max;
    }
    // MEMOIZATION ---------------------------------------------------------------------------------
    public static int solve(int day, int[][] points, int last, int[][] dp) {
        if (dp[day][last] != -1) return dp[day][last];

        if (day == 0) {
            int max = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return max; // Return max directly without assigning to dp[day][last]
        }

        int max = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int findMax = points[day][i] + solve(day - 1, points, i, dp);
                max = Math.max(max, findMax);
            }
        }
        return dp[day][last] = max;
    }

    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4]; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = -1; 
            }
        }
        return solve(n - 1, points, 3, dp);
    }
    public static void main(String[] args) {
        // Define the points for each activity on each day
        int[][] points = {
            {10, 40, 70},
            {20, 50, 80},
            {30, 60, 90}
        };

        int n = points.length; // Get the number of days
        System.out.println(ninjaTraining(n, points)); // Calculate and print the maximum points
    }
}

