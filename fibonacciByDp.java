import java.util.*;
public class fibonacci{
    public static int fibo(int n, int arr[]){
        if(n==0 || n==1) return n;
        if(arr[n]!=0) return arr[n];
        return fibo(n-1,arr)+fibo(n-2,arr);                 //BY MEMONIZATION 
    }
    public static int fiboTabulation(int n, int dp[]){
        dp[0]=0;dp[1]=1;
        for(int i=2;i<n+1;i++){                            // BY TABULATION
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String args[]){
        int n=5;
        int arr[]= new int [5+1];// for memoization
        int ans= fibo(5,arr);
        System.out.println("Nth fibonacci by memoization is : "+ ans);
        int dp[]= new int[n+1];// for tabulation
        ans= fiboTabulation(n,dp);
        System.out.println("Nth fibonacci by Tabulation is : "+ ans);
    }
}
