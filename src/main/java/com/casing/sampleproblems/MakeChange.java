/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

/**
 *
 * @author casing
 */
public class MakeChange {
    
    public static int minCoinsForChange(int amount, int[]coins) {
        int count = 0;
        int coinIndex = coins.length - 1;//Start with largest value
        StringBuilder sb = new StringBuilder();
        sb.append(amount);
        sb.append(" = {");
        while(amount > 0 || coinIndex < 0) {
            if(amount >= coins[coinIndex]) {
                amount = amount - coins[coinIndex];
                sb.append(coins[coinIndex]);
                sb.append(", ");
                count++;
            } else {
                --coinIndex;
            }
        }
        sb.replace(sb.length()-2, sb.length(), "");
        sb.append("}");
        System.out.println(sb);
        return count;
    }
    
    public static void main(String[] args) {
        int[]coins = new int[]{1, 5, 10, 25, 100, 200};
        System.out.println(minCoinsForChange(537, coins) + " coins to make change.");
    }
}
