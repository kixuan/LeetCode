package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kixuan
 * @version 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class l199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        while (root != null) {
            if (root.right != null) {
                list.add(root.val);
                root = root.right;
            } else if (root.left != null) {
                list.add(root.val);
                root = root.left;
            } else {
                list.add(root.val);
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        l199 l199 = new l199();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;
        List<Integer> list = l199.rightSideView(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
