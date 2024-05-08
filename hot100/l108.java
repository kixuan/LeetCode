package hot100;

/**
 * @author kixuan
 * @version 1.0
 */

public class l108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return digui(nums, 0, nums.length - 1);
    }

    public TreeNode digui(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = digui(nums, 0, mid - 1);
        root.right = digui(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        l108 l108 = new l108();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = l108.sortedArrayToBST(nums);
        System.out.println(treeNode.val);
    }
}
