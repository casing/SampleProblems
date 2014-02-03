/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

import java.util.ArrayList;

/**
 *
 * @author casing
 */
public class SecretSanta {
    
    public static int[] secretSanta(int n) {
        int[] a = new int[n];
        ArrayList<Integer> hat = new ArrayList<>();
        for(int i=0;i<n;i++) {
            hat.add(i);
        }
        
        int j = 0;
        for(int i=0;i<n-2;i++) {
            j = (int)(Math.random() * 1000) % hat.size();
            if(hat.get(j) == i) {
                j = (j+1) % hat.size();
            }
            a[i] = hat.remove(j);
        }
        
        if(hat.contains(n-1)) {
            j = (hat.indexOf(n-1) + 1) % hat.size();
            a[n-1] = hat.remove(j);
            a[n-2] = hat.remove(0);
        } else {
            a[n-1] = hat.remove(0);
            a[n-2] = hat.remove(0);
        }
        
        return a;
    }
    
    public static void print(int[] a) {
        for(int i=0;i<a.length;i++) {
            System.out.println(i + " --> " + a[i]);
        }
    }
    
    public static void main(String [] args) {
        print(secretSanta(100));
       
    }
}
