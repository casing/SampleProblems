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
public class SubArraySum {
    
    public static void findSubArraySum(int[] ar) {
        int sum = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int start = 0;
        int i = 0;
        while( i < ar.length) {
            
            if(ar[i] + sum > sum) {
                sum += ar[i];
                maxEnd = i;
                maxStart = start;
            } else {
                start = i + 1;
            }
            i++;
        }
        
        if(sum == 0) {
            System.out.println("Empty Array");
        } else {
            System.out.println("Start i: " + maxStart + ", End i:" + maxEnd);
        }
        
    }
    
    public static void main(String[] args) {
        int [] a1 = new int[] {1, 2, 3, 4, 5};
        int [] a2 = new int[] {-5, -2, -3, -4, -5};
        int [] a3 = new int[] {-1, -2, 3, 4, -5};
        int [] a4 = new int[] {-1, -2, 10, 0, -5};
        int [] a5 = new int[] {-1, 5, 6, -2, 6, 5, -5};
        
        findSubArraySum(a1);
        findSubArraySum(a2);
        findSubArraySum(a3);
        findSubArraySum(a4);
        findSubArraySum(a5);
    }
    
}
