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
public class ShortestSeqToN {
    public int solution(int N) {
        if(N > 0) {
            int steps = 1;//initial value counts as one step
            int sum = 1;
            while(sum != N) {
                if(N - sum >= sum) {
                    sum *= 2;
                    steps++;
                } else {
                   steps += N-sum;
                   break;
                }
            }
            return steps;
        }
        return 0;
    }
    
    public static final void main (String args[]) {
        ShortestSeqToN s = new ShortestSeqToN();
        System.out.println(s.solution(1));
        System.out.println(s.solution(1024));
        System.out.println(s.solution(1027));
        System.out.println(s.solution(Integer.MAX_VALUE));
    }
}
