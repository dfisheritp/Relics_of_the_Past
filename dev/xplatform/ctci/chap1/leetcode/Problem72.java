package dev.xplatform.ctci.chap1.leetcode;

import java.util.Arrays;

/**
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following three operations permitted on a word:
 * 
 * 1. Insert a character
 * 2. Delete a character
 * 3. Replace a character
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * Example 2:
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 * 
 * Constraints:
 * 
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 * 
 */
public class Problem72 {
	public int minDistance(String word1, String word2) {
		int x = word1.length();
		int y = word2.length();
		int[][] m = new int[x + 1][y + 1];
		for (int[] i: m)
		{
			Arrays.fill(i, -1);
		}
		return findPath(word1, word2, x-1, y-1, m);
	}

	public int findPath(String s, String t, int i, int j, int[][] map)
	{
		if (i < 0)
		{
			return j + 1;
		}
		if (j < 0)
		{
			return i + 1;
		}
		if (map[i][j] != -1)
		{
			return map[i][j];
		}
		
		if (s.charAt(i) == t.charAt(j))
		{
			return map[i][j] = findPath(s, t, i - 1, j - 1, map);
		}
		return map[i][j] = Math.min(1 + findPath(s, t, i - 1, j- 1, map),	// repalce
				Math.min(1 + findPath(s, t, i, j - 1, map), 				// insert
						1 + findPath(s, t, i - 1, j, map)));				// delete
	}

}
