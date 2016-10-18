package com.nmvk.raghav;

import java.util.Arrays;
import java.util.Scanner;

public class Coins {

	public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int m = in.nextInt();
	        int coins[] = new int[m];
	        for(int coins_i=0; coins_i < m; coins_i++){
	            coins[coins_i] = in.nextInt();
	    }
	        System.out.println(makeChange(coins, n));;

	}

	public static long makeChange(int[] coins, int money) {
        long[] DP = new long[money + 1]; // O(N) space.
        DP[0] = (long)1; 	// n == 0 case.
        for(int i = 0 ; i < coins.length; i++) {
            int coin = coins[i];
            for(int j = coin; j < DP.length; j++) {
            // The only tricky step.
                DP[j] += (j - coin >= 0 ? DP[j - coin] : 0);
                System.out.println(Arrays.toString(DP));
            }
        }       
        return DP[money];
    } 
}