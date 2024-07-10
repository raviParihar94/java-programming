package dev.beelive.com.Gfg.POTD.jully2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class ClosestThreeSum_9July {
    /* READ ME FIRST
    *   In  BufferedReader first pass the no of test cases you want to run then press enter
    *   pass value of integer like 9 0 2 5 4 like this make sure single space between numbers
    *   last param is target like 3
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(Solution.threeSumClosest(arr, key));
        }
        out.close();
    }

    static class Solution {
        static int threeSumClosest(int[] arr, int target) {
            Arrays.sort(arr);
            int n = arr.length;
            int diff=Integer.MAX_VALUE;
            int ans=Integer.MAX_VALUE;


            for(int i=0; i<n; i++){
                int start = i+1, end =n-1;
                while(start<end){
                    int sum = arr[i] + arr[start] + arr[end];
                    if(sum == target)return target;

                    else if(sum < target){
                        start ++;
                    }else{
                        end --;
                    }

                    int abs = Math.abs(sum - target);

                    if( abs< diff){
                        diff = abs;
                        ans = sum;
                    }

                    if(abs == diff){
                        ans= Math.max(ans,sum);
                    }
                }

            }
            return ans;
        }
    }
}
