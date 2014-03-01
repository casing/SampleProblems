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
public class FindBoggleWords {
    
    private static boolean isWord(String s) {
        return s.endsWith("AT");
    }
    
    private static void printIfWord(String s) {
        if(isWord(s))
            System.out.println(s);
    }
    
    private static void find(boolean[][] visited, char[][] ar, String s, int x, int y) {
        if(ar.length > 0) {
            int colSize = ar[0].length;
            if (x >= 0 && x < ar.length  && y >= 0 && y < colSize) {
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    s += ar[x][y];
                    printIfWord(s);

                    // Visit Children
                    visitChildren(visited, ar, s, x, y);
                    visited[x][y] = false;
                }
            }
        }
    }

    private static void visitChildren(boolean[][] visited, char[][] ar, String s, int x, int y) {
        if(ar.length > 0) {
            int colSize = ar[0].length;
            for(int i=x-1;i<x+2;i++) {
                if(i >= 0 && i < ar.length) {
                    for(int j=y-1;j<y+2;j++) {
                        if(j >= 0 && j < colSize) {
                            if(i != x || j != y) {
                                find(visited, ar, s, i, j);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void findWords(char[][] ar) {
        if(ar != null && ar.length > 0) {
            int colSize = ar[0].length;
            for(int i=0;i<ar.length;i++) {
                for(int j=0;j<colSize;j++) {
                    boolean[][] visited = new boolean[ar.length][colSize];
                    find(visited, ar, new String(), i, j);	
                }
            }
        }
    }
    
    public static void main(String[] args) {
        char[][] ar = new char[][]{{'A', 'B', 'C'},{'D', 'T', 'A'},{'L', 'O', 'E'}};
        findWords(ar);
    }
}
