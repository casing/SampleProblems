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
public class CountMatrix {
 
    public void findCounts(int[][] matrix) {
        
        int maxRowCount = Integer.MIN_VALUE;
        int maxRowIndex = 0;
        int minRowCount = Integer.MAX_VALUE;
        int minRowIndex = 0;
        int maxColCount = Integer.MIN_VALUE;
        int maxColIndex = 0;
        int minColCount = Integer.MAX_VALUE;
        int minColIndex = 0;
    
        for(int i=0;i<matrix.length;i++) {
            int [] row = matrix[i];
            int rowCount = 0;
            int colCount = 0;
            for(int j=0;j<row.length;j++) {
                rowCount += matrix[i][j];
                colCount += matrix[j][i];
                
            }
            if(rowCount > maxRowCount) {
                maxRowCount = rowCount;
                maxRowIndex = i;
            }
            if(rowCount < minRowCount) {
                minRowCount = rowCount;
                minRowIndex = i;
            }
            if(colCount > maxColCount) {
                maxColCount = colCount;
                maxColIndex = i;
            }
            if(colCount < minColCount) {
                minColCount = colCount;
                minColIndex = i;
            }
        }
        
        System.out.println("Max Row at: " + maxRowIndex + " with sum = " + maxRowCount);
        System.out.println("Min Row at: " + minRowIndex + " with sum = " + minRowCount);
        System.out.println("Max Col at: " + maxColIndex + " with sum = " + maxColCount);
        System.out.println("Min Col at: " + minColIndex + " with sum = " + minColCount);
        
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{3, -5, 10},{6, -2, -1},{2, 6, 1}};
        
        CountMatrix cm = new CountMatrix();
        cm.findCounts(matrix);
    }
}
