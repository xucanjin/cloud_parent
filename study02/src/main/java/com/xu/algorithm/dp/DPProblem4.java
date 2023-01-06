package com.xu.algorithm.dp;

import com.xu.algorithm.tree.Node;

import java.util.Arrays;

/**
 * @author xucanjin
 * @date 2022/12/30
 * @description 打家劫舍问题
 */
public class DPProblem4 {
    public static void main(String[] args) {
        rob(new int[]{1,2,3,1});

        //rob2(new int[]{1,3,1});
        rob3(getNode());
    }


    public static Node getNode() {

        // root = [3,2,3,null,3,null,1]

        Node node5 = new Node();
        node5.value = 3;

        Node node6 = new Node();
        node6.value = 1;

        Node node3 = new Node();
        node3.value = 3;
        node3.right = node6;

        Node node2 = new Node();
        node2.value = 2;
        node2.right = node5;

        Node node1 = new Node();
        node1.value = 3;

        node1.left = node2;
        node1.right = node3;
        return node1;
    }

    /**
     * 打家劫舍
     *
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     * 示例 1：
     * 输入：[1,2,3,1] 不能拿相邻的2个数
     * 输出：4
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        // dp[i]：考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            // i如果拿：i-1一定不拿，则最大价值是 dp[i - 2] + nums[i]
            // i如果不拿，最大价值是 dp[i-1]
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        System.out.println(dp[nums.length - 1]);
        return dp[nums.length - 1];
    }


    /**
     * 打家劫舍II
     * 线性数组变成一个环了，
     * 分为2种情况，考虑首元素不考虑尾元素； 考虑尾元素不考虑首元素，取这2种情况的最大值就行
     *
     * 输入：nums = [2,3,2] 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     */
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        // 考虑首元素不考虑尾元素、考虑尾元素不考虑首元素；取这2种情况的最大值
        int max = Math.max(rob(Arrays.copyOf(nums, len - 1)), rob(Arrays.copyOfRange(nums, 1, len)));
        System.out.println("rob2：" + max);
        return max;
    }


    /**
     * 打家劫舍 III
     * 树形dp
     *
     * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
     * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     */
    public static int rob3(Node root) {
        // 这里可以使用一个长度为2的数组，记录当前节点偷与不偷所得到的的最大金钱。
        // dp数组（dp table）以及下标的含义：下标为0记录不偷该节点所得到的的最大金钱，下标为1记录偷该节点所得到的的最大金钱。
        // 所以本题dp数组就是一个长度为2的数组！

        int[] res = robAction(root);
        int max = Math.max(res[0], res[1]);
        System.out.println(max);
        return max;
    }

    /**
     * 不偷：Max(左孩子不偷，左孩子偷) + Max(又孩子不偷，右孩子偷)
     *  root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) +
     *  Math.max(rob(root.right)[0], rob(root.right)[1])
     *  偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
     *  root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
     */
    private static int[] robAction(Node root) {
        // 0 不偷 1偷
        int[] res = new int[2];

        if (root == null) {
            return res;
        }

        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        // 当前节点不偷，取左子树偷和不偷的最大值 + 右子树偷和不偷的最大值
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
        res[1] = root.value + left[0] + right[0];

        return res;
    }
}
