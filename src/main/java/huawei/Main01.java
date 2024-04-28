package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split("\\s+");
        int[] nums = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(scanner.nextLine().trim());

        Arrays.sort(nums); // 对输入数组排序
        TreeNode root = createBalancedBST(nums, 0, nums.length - 1); // 创建平衡BST

        String result = searchBST(root, target); // 搜索并返回结果路径
        System.out.println(result);

        scanner.close();
    }

    // 使用递归方法构建平衡二叉搜索树
    private static TreeNode createBalancedBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createBalancedBST(nums, start, mid - 1);
        node.right = createBalancedBST(nums, mid + 1, end);
        return node;
    }

    // 搜索给定的值并返回搜索路径
    private static String searchBST(TreeNode root, int value) {
        if (root == null) {
            return "SN";  // 如果根节点为空，表示树为空，搜索未开始就失败
        }

        StringBuilder path = new StringBuilder("S");
        TreeNode current = root;

        while (current != null) {
            if (value == current.val) {
                path.append("Y");
                return path.toString();
            } else if (value < current.val) {
                path.append("L");
                current = current.left;
            } else {
                path.append("R");
                current = current.right;
            }

            if(current==null){
                path.deleteCharAt(path.length()-1);
            }

        }

        path.append("N");
        return path.toString();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
