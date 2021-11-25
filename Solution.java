import java.util.*;
import java.util.Deque;

class Solution {

    int [][] dp; // dp[i][j] -> minimum sum starting at grid[i][j]
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];
        for (int i = 0; i<m; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[m-1][n-1] = grid[m-1][n-1];
        return dfs(0, 0, grid, m, n);
    }
    public int dfs (int i, int j, int[][] grid, int m, int n){
        if (i==m || j==n) return Integer.MAX_VALUE;
        if (dp[i][j] != -1) return dp[i][j];
        dp[i][j] = Math.min(dfs(i+1, j, grid, m, n), dfs(i, j+1, grid, m, n)) + grid[i][j];
        return dp[i][j];
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