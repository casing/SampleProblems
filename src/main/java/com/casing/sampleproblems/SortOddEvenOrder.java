/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

/**
 * Sort a set of numbers such that all odd numbers come before even numbers
 * and the relative order of the numbers does not change
 * 
 * i.e. {1, 2, 3, 4, 5, 6} -> {1, 3, 5, 2, 4, 6}
 *      {2, 3, 7, 10, 8, 1} -> {3, 7, 1, 2, 10, 8}
 * 
 * @author casing
 */
public class SortOddEvenOrder {
    
    public static int findFirstEven(int[] a) {
        int i = 0;
        while(i < a.length && a[i] % 2 != 0) {
            i++;
        }
        return i;
    }
    
    public static void shiftValues(int[] a, int i, int j) {
        if(i < j) {
            while(j > i) {
                a[j] = a[j-1];
                j--;
            }
        }
    }
    
    public static void sortOddEven(int a[]) {
        if(a.length > 1) { //array of size 1 or less is considered already sorted
            
            
            // Find index of first even number
            int i = findFirstEven(a);
            int j = i + 1;
            while(true) {
                while(j < a.length && a[j] % 2 == 0) {
                    j++;
                }
                
                if(j >= a.length) {
                    break;
                } else {//switch odd value
                    int odd = a[j];
                    shiftValues(a, i, j);
                    a[i] = odd;
                    i++;
                    j++;
                }
            }
        }
    }
    
    public static void print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for(int i : a) {
            sb.append(i);
            sb.append(" ");
        }
        System.out.println(sb);
    }
    
    public static void main(String[] args) {
        int [] a = {1, 2, 3, 4, 5, 6};
        sortOddEven(a);
        print(a);
    }
}
