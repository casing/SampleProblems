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
public class LargestKSet {
    public int solution(int[] A) {
        int setSize = 0;
        if(A != null && A.length > 0) {
            boolean[] visited = new boolean[A.length];
            for(int i=0;i<A.length;i++) {
                int count = 1;
                int index = i;
                if(!visited[i]) {
                    visited[i] = true;
                    while(A[index] != i) {
                        index = A[index];
                        visited[index] = true;
                        count++;
                    }
                    if(count > setSize) {
                        setSize = count;
                    }
                    if(setSize >= A.length) {
                        break;//This would be the largest set break out
                    }
                }
            }
        }
        return setSize;
    }
    
    public static final void main (String args[]) {
        int[] A = {5,4,0,3,1,6,2};
        int[] B = {0,1,2,3,4,5,6};
        int[] C = {};
        int[] D = new int[1000000];
        for(int i=0;i<D.length;i++) {
            D[i] = D.length - 1 - i;
        }
        int[] E = new int[1000000];
        for(int i=0;i<E.length;i++) {
            E[i] = (i + 1) % E.length;
        }
        LargestKSet k = new LargestKSet();
        System.out.println(k.solution(A));
        System.out.println(k.solution(B));
        System.out.println(k.solution(C));
        System.out.println(k.solution(D));
        System.out.println(k.solution(E));
    }
}
