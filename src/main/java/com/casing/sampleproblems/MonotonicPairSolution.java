package com.casing.sampleproblems;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author casing
 */
public class MonotonicPairSolution {
    public int solution(int[] A) {
        int distance = 0;
        if(A != null) {
            int N = A.length;
            for(int i=0;i<N;i++) {
                for(int j=N-1;j>i+distance;j--) {
                    if(A[i] <= A[j]) {
                        // monotonic_pair
                        if(j-i > distance) {
                            distance = j - i;
                            break;//won't find a greater distance
                        }
                    }
                }
                
                if(distance >= N - i) {
                    break;//won't find a greater distance
                }
            } 
        }
        return distance;
    }
    
    public static final void main(String args[]) {
        int[] A = {5,3,6,3,4,2};
        int[] B = {0,0,0,0,0,0};
        int[] C = {6,5,4,3,2,1};
        int[] D = {5,6,4,3,2,1};
        int[] E = {1,2,3,4,5,6};
        MonotonicPairSolution mps = new MonotonicPairSolution();
        System.out.println(mps.solution(A));
        System.out.println(mps.solution(B));
        System.out.println(mps.solution(C));
        System.out.println(mps.solution(D));
        System.out.println(mps.solution(E));
    }
}
