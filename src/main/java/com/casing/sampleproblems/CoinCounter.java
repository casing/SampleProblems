/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

/**
 * This is a solution to count the number combinations of coins of denomination
 * {1,5,10,25} cents can be used to make up a total amount.
 * 
 * @author casing
 */
public class CoinCounter {
    public static int [] coins = {1,5,10,25};
    
    public int getNumberOfCombinations(int total) {
        return countCombinations(total, 0);
    }
    
    private int countCombinations(int total, int index) {
        
        if(index >= coins.length) {
            return 0;
        }
        
        int count = 0;
        for(int i=index;i<coins.length;i++) {
            int n = total / coins[i];
            for(int j=n;j>0;j--) {
                int newTotal = total-coins[i]*j;
                if(newTotal == 0) {
                    count++;
                } else {
                    count += countCombinations(newTotal, i+1);
                }
            }
        }
        return count;
    }
    
    public static void main(String [] args) {
        CoinCounter cc = new CoinCounter();
        for(int i=0;i<100;i++) {
          System.out.println("Number of combinations for " + i + " cents: " + cc.getNumberOfCombinations(i));  
        }
    }
}
