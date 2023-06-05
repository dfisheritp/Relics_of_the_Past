package dev.xplatform.ctci.chap1.leetcode;

import java.util.Arrays;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of 
 * s1, or false otherwise.
 * 
 * In other words, return true if one of s1's permutations is the substring of 
 * s2.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * Example 2:
 * 
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 *     1 <= s1.length, s2.length <= 10<sup>4</sup>
 *     s1 and s2 consist of lowercase English letters.
 * 
 */
public class Problem567 
{
    public boolean checkInclusion(String s1, String s2)
    {
        if (s1.length() > s2.length())
        {
            return false;
        }

        int ix = s1.length();
        int iy = s2.length() - ix;

        char[] sc = s1.toCharArray();
        Arrays.sort(sc);

        for(int i = 0; i < iy; i++)
        {
            char[] tc = s2.substring(i, i + ix).toCharArray();
            Arrays.sort(tc);
            if (Arrays.equals(sc, tc))
            {
                return true;
            }
        }

        return false;
    }

    public boolean checkInclusionConstrained(String s1, String s2)
    {
        int x = s1.length();
        int y = s2.length();
        if (y < x)
        {
            return false;
        }
        int[] is = new int[26];
        int[] it = new int[26];
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        for (int i = 0; i < x; i++)
        {
            is[a[i] - 'a']++;
            it[b[i] - 'a']++;
        }
        if (Arrays.equals(is, it))
        {
            return true;
        }
        for (int i = x; i < y; i++)
        {
            it[b[i-x] - 'a']--;
            it[b[i] - 'a']++;
            if (Arrays.equals(is, it))
            {
                return true;
            }
        }
        return false;
    }
}
