import java.util.*;
import java.util.Deque;

class Solution {

    int [][][] dp; //dp[i][j][k] -> given the interval [i, j], with k boxes attached to the ith box, what is the best answer
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        dp = new int[n][n][n];
        return dfs(0, n-1, 0, boxes, n);
    }
    public int dfs(int i, int j, int k, int [] boxes, int n) {
        if (i>j) return 0;
        if (dp[i][j][k]!=0) return dp[i][j][k];
        int tempI = i, tempK = k;
        while (i+1<=j && boxes[i]==boxes[i+1]) {
            i++; k++;
        }
        int ret = (k+1)*(k+1) + dfs(i+1, j, 0, boxes, n);
        for (int p = i+1; p<=j; p++) {
            if (boxes[i]==boxes[p]) {
                ret = Math.max(ret, dfs(i+1, p-1, 0, boxes, n) + dfs(p, j, k+1, boxes, n));
            }
        }
        dp[tempI][j][tempK] = ret;
        return ret;
    }






    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    /*
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

     */
}
