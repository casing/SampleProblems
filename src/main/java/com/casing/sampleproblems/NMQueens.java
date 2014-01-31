/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a solution to count the number of ways to place queens on a board 
 * of size N x M without a queen attacking another queen.
 * 
 * @author casing
 */
public class NMQueens {
    public static class Board {
        private boolean [][] board;
        private int n;
        private int m;
        
        public Board(int n, int m) {
            this.n = n;
            this.m = m;
            board = new boolean[n][m];
            clearBoard();
        }
        
        public int getN() {
            return n;
        }
        
        public int getM() {
            return m;
        }
        
        public void clearBoard() {
            if(board != null) {
                for(int i=0;i<n;i++) {
                    for(int j=0;j<m;j++) {
                        board[i][j] = false;
                    }
                }
            }
        }
        
        public List<Queen> getPossibleQueens() {
            List<Queen> queens = new ArrayList<>();
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    if(!board[i][j]){
                        queens.add(new Queen(i,j));
                    }
                }
            }
            return queens;
        }
        
        public void placeQueen(Queen q) {
            if(q != null) {
                int x = q.getX();
                int y = q.getY();
                if(x >=0 && x < n && y >= 0 && y < m) {
                    //mark rows
                    for(int i=0;i<m;i++) {
                        board[x][i] = true;
                    }
                    //mark cols
                    for(int i=0;i<n;i++) {
                        board[i][y] = true;
                    }
                    //mark diagnoals
                    { // Top Right
                        int i = x + 1;
                        int j = y + 1;
                        while(i >= 0 && i < n && j >=0 && j < m) {
                            board[i][j] = true;
                            i++;
                            j++;
                        }
                    }
                    
                    { // Top Left
                        int i = x -1;
                        int j = y + 1;
                        while(i >= 0 && i < n && j >=0 && j < m) {
                            board[i][j] = true;
                            i--;
                            j++;
                        }
                    }
                    
                    { // Bottom Right
                        int i = x + 1;
                        int j = y - 1;
                        while(i >= 0 && i < n && j >=0 && j < m) {
                            board[i][j] = true;
                            i++;
                            j--;
                        }
                    }
                    
                    { // Bottom Left
                        int i = x - 1;
                        int j = y - 1;
                        while(i >= 0 && i < n && j >=0 && j < m) {
                            board[i][j] = true;
                            i--;
                            j--;
                        }
                    }
                }
            }
        }
    }
    
    public static class Queen {
        int x,y;
        public Queen(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
    }
    
    public static int solve(Board b) {
        int count = 0;
        if(b != null && b.getPossibleQueens().size() > 0) {
            List<Queen> queens = b.getPossibleQueens();
            count += queens.size();

            for(Queen q : queens) {
                b.placeQueen(q);
                count += solve(b);
            }
        }
        return count;
    }
    
    public static int solve(int n, int m) {
        int count = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                Board b = new Board(n, m);
                Queen queen = new Queen(i,j);
                b.placeQueen(queen);
                count += solve(b);
            }
        }
        return count;
    }
    
    public static void main(String args[]) {
        System.out.println(solve(8,8));
    }
}
