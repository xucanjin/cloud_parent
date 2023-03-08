package com.xu.algorithm.string;

/**
 * @author xucanjin
 * @date 2023/03/08
 * @description
 */
public class SortProblem {
    public static void main(String[] args) {

        int[] ints = sort1(new int[]{2, 4, 9, 3, 6, 5, 8});
        int[] nums = new int[]{2, 4, 9, 3, 6, 5, 8};
        quickSort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 冒泡排序 将最大的数放到最右边
     *
     * @param nums
     * @return
     */
    public static int[] sort1(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            // 将最大的数放到最右边
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }


    /**
     * 快速排序
     */
    public static void quickSort(int[] nums,int left,int right) {
        if (left > right) {
            return;
        }

        int l1 = left;
        int r1 = right;
        // 基准数
        int basic = nums[left];
        while (l1 < r1) {
            //先看右边，依次往左递减
            while (l1 < r1 && nums[r1] >= basic) {
                r1--;
            }
            while (l1 < r1 && nums[l1] <= basic) {
                l1++;
            }
            if (l1 < r1) {
                int temp = nums[l1];
                nums[l1] = nums[r1];
                nums[r1] = temp;
            }
        }
        // 将基准数和此时左边最大值交换
        nums[left] = nums[l1];
        nums[l1] = basic;
        quickSort(nums, left, l1 - 1);
        quickSort(nums, l1 + 1, right);
    }
}
