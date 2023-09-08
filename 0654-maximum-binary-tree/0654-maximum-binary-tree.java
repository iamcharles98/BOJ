import java.util.*;


class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        TreeNode root = makeTree(nums, 0, nums.length-1);
        return root;
    }

    private static TreeNode makeTree(int [] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int maxIdx = getMaximumNumIndex(nums, start, end);

        TreeNode root = new TreeNode(nums[maxIdx],null,null);
        root.left = makeTree(nums,start, maxIdx-1);
        root.right = makeTree(nums,maxIdx+1, end);

        return root;
    } 
    private static int getMaximumNumIndex(int [] nums, int start, int end) {
        
        int maxIdx = start;
        int maxValue = Integer.MIN_VALUE;
        for(int i=start ; i<=end;i++) {
            if(maxValue < nums[i]) {
                maxValue = nums[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    } 
}