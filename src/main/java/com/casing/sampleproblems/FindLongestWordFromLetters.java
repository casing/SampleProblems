/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.casing.sampleproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Given a dictionary, and a list of letters ( or consider as a string), find the longest word that only uses letters from the string.
 * @author casing
 */
public class FindLongestWordFromLetters {
    
    private static Map<Character, Integer> mapLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
    
    public static String longestWordFromLetters(String[] dict, String letters) {
        String result = "";
        Map<Character, Integer> lettersMap = mapLetters(letters);
        for(String s : dict) {
            if(s.length() > result.length() && isWordOfLetters(s, lettersMap)) {
                result = s;
            }
        }
        return result;
    }
    
    public static boolean isWordOfLetters(String word, Map<Character, Integer> lettersMap) {
        Map<Character, Integer> wordLettersMap = mapLetters(word);
        Set<Entry<Character, Integer>> entrySet = wordLettersMap.entrySet();
        for(Entry<Character, Integer> e : entrySet) {
            if(lettersMap.containsKey(e.getKey())) {
                if(lettersMap.get(e.getKey()) < e.getValue()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String[] dict = new String[]{"hat", "cat", "hello", "world", "le"};
        String letters = "el";
        System.out.println("Longest word is: " + longestWordFromLetters(dict, letters));
    }
    
}
