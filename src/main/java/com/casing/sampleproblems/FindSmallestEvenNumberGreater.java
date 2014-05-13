/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author casing
 */
public class FindSmallestEvenNumberGreater {
    public static String findSmallestEvenNumberGreater(int a) {
        String value = String.valueOf(a);
        List<Integer> list = new ArrayList<>();
        int index = value.length() - 1;
        Integer valueFound = null;
        boolean evenFound = false;
        while(index >= 0) {
            int currentValue = Integer.valueOf(String.valueOf(value.charAt(index)));
            if(currentValue % 2 == 0) {
                evenFound = true;
            }
            list.add(currentValue);
            Collections.sort(list);
            
            if(evenFound && list.get(list.size()-1) > currentValue) {
                valueFound = currentValue;
                break;
            }
            index--;
        }
        
        if(valueFound != null) {
            Collections.sort(list);
            for(Integer i : list) {
                if(i > valueFound) {
                   value = value.substring(0, index);
                   value += i;
                   list.remove(i);
                   break;
                }
            }
            
            Integer greatestEven = null;
            int len = list.size();
            for(int i=len-1;i>=0;i--) {
                if(list.get(i) % 2 == 0) {
                    greatestEven = list.get(i);
                    list.remove(i);
                    break;
                }
            }
            
            for(Integer i : list) {
                value += i;
            }
            
            value += greatestEven;
            
            return value;
        }
        
        return "None";
    }
    
    public static final void main(String [] args) {
        System.out.println(findSmallestEvenNumberGreater(34722641));
        System.out.println(findSmallestEvenNumberGreater(87654321));
        System.out.println(findSmallestEvenNumberGreater(34321));
        System.out.println(findSmallestEvenNumberGreater(22222));
        System.out.println(findSmallestEvenNumberGreater(11111));
        System.out.println(findSmallestEvenNumberGreater(123579));
    }
}
