package ru.job4j.tested;

import java.util.Arrays;

public class Recursive {
    public static void recurse(int a, int[] nums) {
        int cnt = (nums.length - 1) / 2;
        System.out.print(nums[cnt] + " ");
        if (nums.length > 1) {
            int[] n1 = Arrays.copyOfRange(nums, cnt + 1, nums.length);
            recurse(a, n1);
            int[] n2 = Arrays.copyOfRange(nums, 0, cnt);
            recurse(a, n2);
        }
    }

    public static void main(String[] args) {
        int a = 7;
        int[] nums = {4, 7, 10, 7, 5, 5, 1};
        Recursive.recurse(a, nums);
    }
}