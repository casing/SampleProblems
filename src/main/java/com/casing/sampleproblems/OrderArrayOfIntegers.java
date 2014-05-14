/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

/**
 * http://www.careercup.com/question?id=4669539153346560
 * @author casing
 */
public class OrderArrayOfIntegers {
    public static void orderArray(int ar[], int index[]) {
        if(ar != null && index != null && ar.length > 0 && ar.length == index.length) {
            for(int i=0;i<ar.length;i++) {
                int next = index[i]-1;
                if(next < index.length) {
                    int tmp = ar[i];
                    int cur = i;
                    while(next < ar.length) {
                        int tmp2 = ar[next];
                        ar[next] = tmp;
                        tmp = tmp2;
                        index[cur] += ar.length;
                        cur = next;
                        next = index[cur] - 1;
                    }
                }
            }
            
            // reset index array
            for(int i=0;i<index.length;i++) {
                index[i] -= index.length;
            }
        }
    }
    
    private static void printArray(int ar []) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ar.length;i++) {
            sb.append(ar[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
    
    public static final void main(String [] args) {
        int [] ar = {17, 5, 1, 9, 2, 3, 4, 5, 2, 1, 34, 343, 21};
        int [] index = { 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        
        orderArray(ar, index);
        printArray(ar);
        printArray(index);
    }
}
