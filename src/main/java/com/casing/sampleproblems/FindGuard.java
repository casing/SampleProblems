/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

/**
 * Given a 2-D matrix represents the room, obstacle and guard like the following (0 is room, B->obstacle, G-> Guard): 
    0 0 0 
    B G G 
    B 0 0 

    calculate the steps from a room to nearest Guard and set the matrix, like this 
    2 1 1 
    B G G 
    B 1 1 
    Write the algorithm, with optimal solution.
 * @author casing
 */
public class FindGuard {
    
    private static void dfs(int[][] matrix, int x, int y, int step) {
        if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length)
            return;
        
        if(matrix[x][y] < 0)
            return;
        
        if(matrix[x][y] > step + 1 || matrix[x][y] == 0) {
            matrix[x][y] = step + 1;
        } else {
            return;
        }
        dfs(matrix, x + 1, y, step + 1);
	dfs(matrix, x, y + 1, step + 1);
	dfs(matrix, x - 1, y, step + 1);
	dfs(matrix, x, y - 1, step + 1);
    }
    
    public static int[][] nearestGuard(int[][] matrix) {
        if(matrix.length > 0) {
            for(int x = 0;x<matrix.length;x++) {
                for(int y=0;y<matrix[x].length;y++) {
                    if (matrix[x][y] == -1) {
                        dfs(matrix, x-1, y, 0);
                        dfs(matrix, x, y-1, 0);
                        dfs(matrix, x+1, y, 0);
                        dfs(matrix, x, y+1, 0);
                    }
                }
            }
        }
        return null;
    }
    
    public static void printMatrix(int[][] matrix) {
        if(matrix.length > 0) {
            for(int x = 0;x<matrix.length;x++) {
                String line = "";
                for(int y=0;y<matrix[x].length;y++) {
                    if(matrix[x][y] == -2) {
                        line += "B ";
                    } else if(matrix[x][y] == -1) {
                        line += "G ";
                    } else {
                        line += matrix[x][y] + " ";
                    }
                }
                System.out.println(line);
            }
        }
    }
    
    public static final void main(String[] args) {
        // let -2, B and -1, G
        int[][] matrix = new int[][]{{0,0,0, 0},{0,-2,-1,-1},{0,-2,0,0},{0,0,0,0}};
        nearestGuard(matrix);
        printMatrix(matrix);
    }
}
