/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

import java.util.Scanner;

/**
 *
 * @author casing
 */
public class ArithmeticSequenceMissing {
    
    public static int findASMissing(int[] ar) {
        if(ar.length >= 3 && ar.length <= 2500) {
            int i = 0;
            int s1 = 0;
            int s2 = 0;
            while(i < ar.length - 2) {
                s1 = ar[i+1] - ar[i];
                s2 = ar[i+2] - ar[i+1];
                
                if(s1 > s2) {
                    return ar[i] + s2;
                } else if(s1 < s2) {
                    return ar[i+1] + s1;
                }
                i++;
            }
        }
        return 0;
    }
    
    public static int findASMissing2(int[] ar) {
        if(ar.length >= 3 && ar.length <= 2500) {
            int i = 2;
            int s1 = 0;
            int s2 = 0;
            int len = ar.length % 2 == 0 ? ar.length - 1 : ar.length;
            while(i < len) {
                s1 = ar[i-1] - ar[i-2];
                s2 = ar[i] - ar[i-1];
                
                if(s1 > s2) {
                    return ar[i-2] + s2;
                } else if(s1 < s2) {
                    return ar[i-1] + s1;
                }
                
                i+=2;
            }
            
            // If we are here then there is one last index to check
            return ar[ar.length-2] + s1;
        }
        return 0;
    }
    
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] ar = new int[size];
        for(int i=0;i<size;i++) {
            ar[i] = sc.nextInt();
        }
        System.out.println(findASMissing2(ar));
    }
}
