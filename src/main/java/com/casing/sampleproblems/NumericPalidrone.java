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
public class NumericPalidrone {
    
    public static void numericPalidrone (int n) {
        
        for(int i=0;i<n;i++) {
            String s = String.valueOf(i);
            int len = s.length();
            int left = 0;
            int right = len-1;
            while(s.charAt(left) == s.charAt(right)) {
                
                if(left >= right) {
                    System.out.println(i);
                    break;
                }

                left++;
                right--;
            }
        }
    }
    
    public static void main(String [] args) {
        numericPalidrone(1000);
    }
    
}
