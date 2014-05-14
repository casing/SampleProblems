/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

/**
 * http://www.careercup.com/question?id=5653018213089280
 * @author casing
 */
public class SlidingWindow {
    public static int minWindowSize(int ar[], int value) {
        int minSize = -1;
        
        for(int i=0;i<ar.length;i++) {
            int sum = 0;
            int slide = i;
            int curSize = 0;
            
            while(sum <= value && slide < ar.length) {
                sum += ar[slide];
                curSize++;
                if(sum <= value) {
                    slide++;
                } else {
                    //update minSize
                    if(minSize == -1 || curSize < minSize) {
                        minSize = curSize;
                    }
                }
            }
        }
        
        return minSize;
    }
    
    public static int minWindowSize2(int ar[], int value) {
        int minSize = -1;
        
        if(ar != null && ar.length > 0) {
            int curSize = 0;
            int start = 0;
            int end = 0;
            int sum = 0;
            
            while(start < ar.length) {

                if(sum <= value) {
                    if(end < ar.length) {
                        sum += ar[end];
                        curSize++;
                        end++;
                    } else {
                        break;
                    }
                } else {
                    sum -= ar[start];
                    curSize--;
                    start++;
                }
                
                if(sum > value) {
                    if(minSize == -1 || curSize < minSize) {
                        minSize = curSize;
                    }
                }
            }
        }
        
        return minSize;
    }
    
    public static final void main(String [] args) {
        int ar[] = { 2, 1, 1, 4, 3, 6};
        System.out.println(minWindowSize2(ar, 3));
    }
}
