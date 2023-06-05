package dev.xplatform.ctci.chap1.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Given an integer array nums, return true if any value appears at least 
 * twice in the array, and return false if every element is distinct.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1]
 * Output: true
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3,4]
 * Output: false
 * 
 * Example 3:
 * 
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * 
 * 
 * 
 * Constraints:
 *     1 <= nums.length <= 10<sup>5</sub>
 *     -109 <= nums[i] <= 10<sup>9</sub>
 * 
 */
public class Problem217
{
    public boolean containsDuplicate(int[] num)
    {
        Set<Integer> hashSet = new HashSet<Integer>(
            IntStream.of(num).boxed().toList());
        
        return hashSet.size() != num.length;
    }

    public boolean containsDuplicate(int[] num, String method)
    {
        switch (method)
        {
            case "n log n":
            case "map iteration":
            case "map": {
                // Time: O(n log n)
                // Space: O(n) * 2
                Map<Integer, Integer> map = new HashMap<>();
                for (int n: num)
                {
                    if (map.containsKey(n))
                    {
                        map.put(n, map.get(n) + 1);
                        return true;
                    }
                    map.put(n, 1);
                }
                return false;
            }
            case "linear sorted":
            case "sorted":
            default: {
                // Time: O(n log n) + n
                // Space: O(1) * 4
                Arrays.sort(num);
                int previousValue = num[0];
                for (int i = 1; i < num.length; i++)
                {
                    if (previousValue != num[i])
                    {
                        previousValue = num[i];
                    }
                    else
                    {
                        return true;
                    }
                }
                return false;
            }
        }

    }
}