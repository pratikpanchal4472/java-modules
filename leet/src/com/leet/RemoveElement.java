package com.leet;

public class RemoveElement {
    static class Solution {
        public int removeElement(int[] numbers, int val) {
            int k = 0;
            for (int i = 0; i < numbers.length; i++) {
                // If the current element is not equal to val
                if (numbers[i] != val) {
                    // Move it to the front of the array
                    numbers[k] = numbers[i];
                    k++;
                }
            }
            return k;
        }
    }

    public static void run() {
        Solution solution = new Solution();
        int[] numbers = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int element = solution.removeElement(numbers, 2);
        System.out.println(element);
    }
}
