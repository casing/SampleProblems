/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

/**
 *  Facebook phone interview question Mar. 3, 2014
 * 
 *  Find the output array which is the product of all other index values.  
 *  Find the O(n) solution.
 * 
 *  array   [2, 3, 1, 4]
 *  output: [12, 8, 24, 6]
 *  no division
 * 
 * @author casing
 */
public class ArrayMultiple {
    
    /* Solution in O(n)*/
    public static int[] productArrayBigOhN(int[] ar) {
        int[] sumsAr = new int[ar.length * 2];
        int[] out = new int[ar.length];
        
        // build Sums array
        if(sumsAr.length > 0) {
            sumsAr[0] = sumsAr[sumsAr.length - 1] = 1;//Initialize end values to 1
            
            // Calculate the Sums array
            for(int i=0;i<ar.length - 1;i++) {
                sumsAr[i+1] = sumsAr[i] * ar[i];//Calculate front values of SumsAr
                sumsAr[sumsAr.length - 2 - i]= sumsAr[sumsAr.length - 1 - i] * ar[ar.length - 1 - i]; //Calculate end values of SumsAr
            }
            
            // Output multiples by gathering sums
            for(int i=0;i<out.length;i++) {
                out[i] = sumsAr[i] * sumsAr[out.length + i];
            }
        }
        return out;
    }
    
    public static int[] productArray(int[] ar) {
        int[] out = new int[ar.length];
        for(int i=0;i<out.length;i++) {
            out[i] = 1;
        }
        
        for(int i=0;i<ar.length;i++) {
            for(int j=0;j<out.length;j++){
                if( i != j) {
                    out[j] *= ar[i];
                }
            }
        }
        return out;
    }
    
    public static void main(String[] args) {
        int[] ar = new int[]{2, 3, 1, 4};
        int[] out = productArrayBigOhN(ar);
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i=0;i<out.length;i++) {
            sb.append(out[i]);
            sb.append(" ");
        }
        sb.append("}");
        System.out.println(sb.toString());
    }
}
