/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

import java.util.Scanner;

/**
 * Mastermind is a game of two players. In the beginning, first player decides a secret key, which is a sequence (s1,s2,...sk) where 0 < si <= n, Then second player makes guesses in rounds, where each guess is of form (g1,g2, ...gk), and after each guess first player calculates the score for the guess. Score for a guess is equal to number of i's for which we have gi = si.
    For example if the secret key is (4,2,5,3,1) and the guess is (1,2,3,7,1),then the score is 2, because
    g2 = s2 and g5 = s5. 

    Given a sequence of guesses, and scores for each guess, your program must decide if there exists at least one secret key that generates those exact scores.

    Input

    First line of input contains a single integer C (1 <=C <= 100). C test-cases follow. First line of each test-case contains three integers n,k and q. (1 <=n,k <=11, 1<=q<=8). Next q lines contain the guesses.

    Each guess consists of k integers gi,1, gi,2,....gi,k separated by a single space, followed by the score for the guess bi (1 <= gi,j <=n for all 1 <=i <=q, 1 <=j <=k; and 0 <= bi <=k )

    Output

    For each test-case, output "Yes" (without quotes), if there exists at least a secret key which generates those exact scores, otherwise output "No".

    Sample Input
    4

    4 4 4
    1 2 3 4 0
    1 3 2 1 1
    4 2 1 3 2
    1 1 1 1 1
    4 4 4
    1 2 3 4 4
    1 2 3 1 3
    1 2 2 1 2
    2 2 2 2 1
    4 4 2
    2 1 2 2 0
    2 2 1 1 1
    4 4 2
    1 2 3 4 4
    4 3 2 1 1

    Sample Output

    Yes 
    Yes
    Yes
    No
    
    * 
    * 
    * 
* 
 * @author casing
 */
public class MasterMind {
    
    private static void setNotGuess(boolean[] guessAr, int notGuess) {
        if(notGuess <= guessAr.length) {
            guessAr[notGuess - 1] = true;
        }
    }
    
    private static void setGuess(boolean[] guessAr, int guess) {
        for(int i=0;i<guessAr.length;i++) {
            if(i != (guess - 1)) {
                guessAr[i] = true;
            }
        }
    }
    
    private static boolean doesKeyExist(boolean[][] notValues) {
        boolean keyExists = true;
        for(int i=0;i<notValues.length;i++) {
            boolean digitExists = false;
            for(int j=0;j<notValues[i].length;j++) {
                if(!notValues[i][j]) {
                    digitExists = true;
                    break;
                }
            }
            keyExists = keyExists && digitExists;
            
            if(!keyExists) {
                break;
            }
        }
        return keyExists;
    }
    
    private static boolean[][] copyArray(boolean[][] src) {
        if(src.length > 0) {
            boolean[][] dst = new boolean[src.length][src[0].length];
            for(int i=0;i<src.length;i++) {
                System.arraycopy(src[i], 0, dst[i], 0, src[0].length);
            }
            return dst;
        }
        return null;
    }
    
    private static boolean isSecretKey(boolean[][] notValues, int[][] ar, int[] guesses, int lineIndex, int charIndex, int count) {
        if(ar.length > 1) {
            int k = ar[0].length;
            int q = ar.length;
            
            if(lineIndex < q) {
                for(int i=charIndex;i<k;i++) {
                    if(count == 0) {
                        // If we are here then there are no more static values so lets set what values can not be
                        // then test if a secret key exists
                        boolean[][] tempNotValues = copyArray(notValues);
                        for(int j=i;j<k;j++) {
                            setNotGuess(tempNotValues[j],ar[lineIndex][j]);
                        }

                        if(doesKeyExist(tempNotValues)) {
                            if(lineIndex + 1 < q) {
                                int newLineIndex = lineIndex + 1;
                                return isSecretKey(tempNotValues, ar, guesses,newLineIndex, 0, guesses[newLineIndex]);//We have gone through all items
                            } else {
                                return true;
                            }
                        }
                    } else {
                        // If we are here then there are still values to iterate through
                        boolean[][] tempNotValues = copyArray(notValues);//TODO: Better way to other than copying
                        setGuess(tempNotValues[i], ar[lineIndex][i]);
                        if(doesKeyExist(tempNotValues)) {
                            if(count - 1 == 0 && (i + 1) == k) {// If there is no more count go to nextLineIndex
                                if(lineIndex + 1 < q) {
                                    return isSecretKey(tempNotValues, ar, guesses,lineIndex + 1, 0, guesses[lineIndex + 1]);//We have gone through all items
                                } else {
                                    return true;
                                }
                            } else {
                               return isSecretKey(tempNotValues, ar, guesses, lineIndex, i+1, count-1); 
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean isSecretKeyPossible(int[][]ar, int[] guesses, int n) {
        if(ar.length > 1) {
            return isSecretKey(new boolean[ar[0].length][n], ar, guesses, 0, 0, guesses[0]);
        }
        return false;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for(int i=0;i<C;i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int q = sc.nextInt();
            int [][] ar = new int[q][k];
            int [] guesses = new int[q];
            for(int l=0;l<q;l++) {
                for(int j=0;j<k;j++) {
                    ar[l][j] = sc.nextInt();
                }
                guesses[l] = sc.nextInt();
            }
            
            if(isSecretKeyPossible(ar, guesses, n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
