/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

/**
 * http://www.careercup.com/question?id=5661939564806144
 * @author casing
 */
public class PrintMatrixDiagonally {
    
    public static void printDiagonally(int ar[][]) {
        StringBuilder sb = new StringBuilder();
        if(ar != null && ar.length > 0) {
            for(int i=0;i<ar[0].length;i++) {
                int r = 0;
                int c = i;
                while(r < ar.length && c >= 0) {
                    sb.append(ar[r][c]);
                    sb.append(" ");
                    r++;
                    c--;
                }
                sb.append("\n");
            }
            
            for(int i=1;i<ar.length;i++) {
                int r = i;
                int c = ar[0].length - 1;
                while(r < ar.length && c >= 0) {
                    sb.append(ar[r][c]);
                    sb.append(" ");
                    r++;
                    c--;
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    
    public static void printDiagonally2(int ar[][]) {
        StringBuilder sb = new StringBuilder();
        if(ar != null && ar.length > 0 && ar[0].length > 0 ) {
            int diagonals = ar.length + ar[0].length - 1;
            int row = 0;
            int col = 0;
            for(int i=0;i<diagonals;i++) {
                int r = row;
                int c = col;
                while(r < ar.length && c >= 0) {
                    sb.append(ar[r][c]);
                    sb.append(" ");
                    r++;
                    c--;
                }
                sb.append("\n");
                
                if(col == (ar[0].length - 1)) {
                    row++;
                } else {
                    col++;
                }
            }
        }
        System.out.println(sb.toString());
    }
    
    public static final void main (String [] args) {
        int ar [][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int ar2 [][] = {{1,2,3},{4,5,6},{7,8,9}};
        printDiagonally2(ar);
        printDiagonally2(ar2);
    }
}
