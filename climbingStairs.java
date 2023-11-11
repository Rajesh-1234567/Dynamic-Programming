public class climbStairs {
    public static int waysByRecursion(int n){
        if(n==0) return 1;                           // BY RECURSION ONLY
        if(n<0) return 0; // there is no negative stairs
        return waysByRecursion(n-1)+waysByRecursion(n-2);
    }
    public static int waysByMemonization(int dp[],int n){
        if(n==0) return 1;
        if(n<0) return 0; 
        if(dp[n]!=0) return dp[n];                       // BY MEMONIZATATION AND RECURSION
        return waysByMemonization(dp,n-1)+waysByMemonization(dp,n-2);
    }
    public static int waysByTabulation(int dp[],int n){
        for(int i=2;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        } 
        return dp[n];                                   // BY TABULATATION
    }
    public static void main(String args[]){
        int n=5; // n steps to go
        int ans= waysByRecursion(n);
        System.out.println(ans);
        int dp[]= new int[n+1];
        dp[0]=1;dp[1]=1;
        ans= waysByMemonization(dp,n);
        System.out.println(ans);
        for(int i=0;i<n+1;i++) dp[0]=0;
        dp[0]=1;dp[1]=1;
        ans= waysByTabulation(dp,n);
        System.out.println(ans);
    }
}
