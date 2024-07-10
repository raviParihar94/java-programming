package dev.beelive.com.Gfg.POTD.jully2022;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LargestSquareFormedInAMatrix_10july {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            System.out.println(Solution.maxSquare(n, m, mat));
        }
    }

     static class Solution {
         static int solve(int i, int j, int[][] mat, int[][] dp) {
             // base case
             if (i >= mat.length || j >= mat[0].length) {
                 return 0;
             }

             if (dp[i][j] != -1) {
                 return dp[i][j];
             }

             // recursive case
             int right = solve(i, j + 1, mat, dp);
             int diagonal = solve(i + 1, j + 1, mat, dp);
             int down = solve(i + 1, j, mat, dp);

             if (mat[i][j] == 1) {
                 dp[i][j] = 1 + Math.min(right, Math.min(diagonal, down));
                 return dp[i][j];
             } else {
                 return dp[i][j] = 0;
             }
         }

         static int maxSquare(int n, int m, int[][] mat) {
             int maxi = 0;
             int[][] dp = new int[n][m];
             for (int[] dptemp : dp) {
                 Arrays.fill(dptemp, -1);
             }

             for (int i = 0; i < n; i++) {
                 for (int j = 0; j < m; j++) {
                     if (mat[i][j] == 1) {
                         maxi = Math.max(maxi, solve(i, j, mat, dp));
                     }
                 }
             }

             return maxi;
         }
    }
}
