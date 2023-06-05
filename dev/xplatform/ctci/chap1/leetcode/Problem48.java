package dev.xplatform.ctci.chap1.leetcode;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 
 * 90 degrees (clockwise).
 * 
 * You have to rotate the image in-place, which means you have to modify the 
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the 
 * rotation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * 
 * Example 2:
 * 
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * 
 * 
 * 
 * Constraints:
 * 
 *     n == matrix.length == matrix[i].length
 *     1 <= n <= 20
 *     -1000 <= matrix[i][j] <= 1000
 * 
 * 
 */
public class Problem48 {
    public void rotate(int[][] M)
    {
        for (int L = 0, U = M.length - 1; L < U; L++, U--)
        {
            for (int o = 0; o < U - L; o++)
            {
                int l = L + o, u = U - o;
                // Save the top left
                int c = M[L][l];

                // Move bottom left to upper left
                M[L][l] = M[u][L];

                // Move bottom right to bottom left
                M[u][L] = M[U][u];

                // Move upper right to lower right
                M[U][u] = M[l][U];

                // move saved cell (upper left) to upper right
                M[l][U] = c;
            }
        }
    }
}
