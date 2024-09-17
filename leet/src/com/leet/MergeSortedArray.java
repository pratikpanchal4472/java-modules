package com.leet;

import java.util.Arrays;

public class MergeSortedArray {
    static class Solution {
        public void merge(int[] numbers1, int m, int[] numbers2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int p = m + n - 1;

            // Merge the arrays starting from the end
            while (p1 >= 0 && p2 >= 0) {
                if (numbers1[p1] > numbers2[p2]) {
                    numbers1[p] = numbers1[p1];
                    p1--;
                } else {
                    numbers1[p] = numbers2[p2];
                    p2--;
                }
                p--;
            }

            while (p2 >= 0) {
                numbers1[p] = numbers2[p2];
                p2--;
                p--;
            }
        }
    }

    public static void run() {
        Solution solution = new Solution();
        int[] numbers1 = { 1, 2, 3, 0, 0, 0 };
        int[] numbers2 = { 2, 5, 6 };
        solution.merge(numbers1, 3, numbers2, 3);
        System.out.println(Arrays.toString(numbers1));
    }
}