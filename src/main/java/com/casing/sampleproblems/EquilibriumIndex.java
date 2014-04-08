/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

import java.math.BigInteger;

/**
 *
 * @author casing
 */
public class EquilibriumIndex {
    public int solution(int[] A) {
        if(A != null && A.length > 0) {
            BigInteger sum = BigInteger.valueOf(0);
            for(int i=0;i<A.length;i++) {
                sum = sum.add(BigInteger.valueOf(A[i]));
            }
            
            BigInteger leftSum = BigInteger.valueOf(0);
            for(int i=0;i<A.length;i++) {
                BigInteger rightSum = sum.subtract(leftSum).subtract(BigInteger.valueOf(A[i]));
                if(leftSum.equals(rightSum)) {
                    return i;
                }
                leftSum = leftSum.add(BigInteger.valueOf(A[i]));
            }
        }
        return -1;
    }
    
    public static final void main (String args[]) {
        int[]A={-7,1,5,2,-4,3,0};
        EquilibriumIndex e = new EquilibriumIndex();
        System.out.println(e.solution(A));
    }
}
