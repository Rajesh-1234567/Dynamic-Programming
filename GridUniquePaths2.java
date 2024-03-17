public class GridUniquePaths2 {
        public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
            for (int i = 0; i < obstacleGrid.length; i++) {
                for (int j = 0; j < obstacleGrid[0].length; j++) {
                    dp[i][j] = -1;
                }
            }
            return find(obstacleGrid.length - 1, obstacleGrid[0].length - 1, obstacleGrid, dp);
        }
    
        public static int find(int i, int j, int obstacleGrid[][], int[][] dp) {
            if (i < 0 || j < 0 || obstacleGrid[i][j] == 1) return 0;
            if (i == 0 && j == 0) return 1;
            if (dp[i][j] != -1) return dp[i][j];
            int left = find(i - 1, j, obstacleGrid, dp);
            int up = find(i, j - 1, obstacleGrid, dp);
            return dp[i][j] = left + up;
        }
        public static void main(String[] args) {
            int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
            };
            System.out.println("Unique paths with obstacles: " + uniquePathsWithObstacles(obstacleGrid));
        }
    }
    

