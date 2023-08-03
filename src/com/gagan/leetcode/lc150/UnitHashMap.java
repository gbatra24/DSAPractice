package com.gagan.leetcode.lc150;

import java.util.HashMap;
import java.util.Map;

public class UnitHashMap {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog dog dog dg"));
    }

    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        boolean isMatch = true;
        String[] strings = s.split(" ");
        if (pattern.length() == strings.length) {
            for (int i = 0; i < pattern.length(); i++) {
                if (map.containsKey(pattern.charAt(i))) {
                    if (map.get(pattern.charAt(i)).equalsIgnoreCase(strings[i])) {
                        continue;
                    } else {
                        isMatch = false;
                        break;
                    }
                } else {
                    if (map.containsValue(strings[i])) {
                        isMatch = false;
                        break;
                    } else {
                        map.put(pattern.charAt(i), strings[i]);
                        continue;
                    }
                }
            }
        } else {
            isMatch = false;
        }
        return isMatch;
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        boolean isIsomorphic = true;
        if (s.length() == t.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    if (map.get(s.charAt(i)) == t.charAt(i)) {
                        continue;
                    } else {
                        isIsomorphic = false;
                        break;
                    }
                } else {
                    if (map.containsValue(t.charAt(i))) {
                        isIsomorphic = false;
                        break;
                    } else {
                        map.put(s.charAt(i), t.charAt(i));
                        continue;
                    }
                }
            }
        } else {
            isIsomorphic = false;
        }
        return isIsomorphic;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransom = new HashMap<>();
        HashMap<Character, Integer> mag = new HashMap<>();
        int i = 0;
        while(i < ransomNote.length()) {
            if (ransom.containsKey(ransomNote.charAt(i))) {
                ransom.put(ransomNote.charAt(i), ransom.get(ransomNote.charAt(i))+1);
            } else {
                ransom.put(ransomNote.charAt(i), 1);
            }
            i++;
        }
        i = 0;
        while(i < magazine.length()) {
            if (mag.containsKey(magazine.charAt(i))) {
                mag.put(magazine.charAt(i), mag.get(magazine.charAt(i))+1);
            } else {
                mag.put(magazine.charAt(i), 1);
            }
            i++;
        }
        for(Map.Entry<Character, Integer> entry: ransom.entrySet()) {
            try {
                if (mag.get(entry.getKey()) < entry.getValue()) {
                    return false;
                } else {
                    continue;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}
