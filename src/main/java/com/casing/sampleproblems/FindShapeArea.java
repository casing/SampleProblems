/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

/**
 * http://www.careercup.com/question?id=5696362200956928
 * @author casing
 */
public class FindShapeArea {
    
    public static int countChar(boolean visited[][], char mat[][], int r, int c, char color) {
        if(mat.length > 0 && mat[0].length > 0 && mat.length > r && mat[0].length > c && visited.length == mat.length && visited[0].length == mat[0].length) {
            if(!visited[r][c] && mat[r][c] == color) {
                int count = 1;
                visited[r][c] = true;
                
                // Top, left, right, bot
                count += countChar(visited, mat, r - 1, c, color);
                count += countChar(visited, mat, r, c - 1, color);
                count += countChar(visited, mat, r, c + 1, color);
                count += countChar(visited, mat, r + 1, c, color);
                
                return count;
            }
        }
        return 0;
    }
    
    public static int getShapeArea(char mat[][], int r, int c) {
        if(mat.length > 0 && mat[0].length > 0 && mat.length > r && mat[0].length > c) {
            boolean visited[][] = new boolean[mat.length][mat[0].length];
            char color = mat[r][c];
            return countChar(visited, mat, r, c, color);
        }
        return 0;
    }
    
    public static final void main(String[] args) {
        char mat [][] = {
            {'0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0'},
            {'0','0','R','R','R','R','0','0','0'},
            {'0','0','R','R','R','R','0','0','0'},
            {'0','0','R','R','R','R','R','0','0'},
            {'0','0','0','0','0','0','R','0','0'},
            {'0','0','0','0','0','0','R','0','0'},
            {'0','0','0','0','0','0','R','0','0'}};
        System.out.println(getShapeArea(mat, 3, 2));
    }
}
