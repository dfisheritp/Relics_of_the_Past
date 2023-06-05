package dev.xplatform.ctci.chap1.leetcode;

import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false 
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a 
 * different word or phrase, typically using all the original letters exactly 
 * once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Example 2:
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 *     1 <= s.length, t.length <= 5 * 10<sup>4</sup>
 *     s and t consist of lowercase English letters.
 * 
 * 
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you 
 * adapt your solution to such a case?
 * 
 */
public class Problem242 
{
    public boolean isAnagram(String s, String t)
    {
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);
    }

    // Unicode response in comments.
    public boolean isAnagramConstrained(String s, String t)
    {
        int[] arr = new int[26];
        if (s.length() != t.length())
        {
            return false;
        }
        // Map<Character, Interger> map = new HashMap<Character, Integer>();
        for(char c: t.toCharArray())
        {
            arr[c - 'a']++;
            //map.put(c, Objects.requireNonNullElse(c.get(c), 0) + 1);
        }
        for(char c: s.toCharArray())
        {
            // if (!map.contains(c))
            if (arr[c - 'a'] == 0)
            {
                return false;
            }
            arr[c - 'a']--;
            // map.put(c, map.get(c) - 1)
            // if (map.get(c) == 0) map.remove(c)
        }
        return true;
    }
}
