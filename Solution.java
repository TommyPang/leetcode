import java.util.*;
import java.util.Deque;

class Solution {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        int[][] psa = new int[m+1][n+1];
        for (int i = 1; i<=m; i++) {
            for (int j = 1; j<=n; j++) {
                psa[i][j] = psa[i-1][j] + psa[i][j-1] - psa[i-1][j-1] + mat[i-1][j-1];
            }
        }
        for (int i = 1; i<=m; i++) {
            for (int j = 1; j<=n; j++) {
                int r1 = Math.max(1, i-k), c1 = Math.max(1, j-k);
                int r2 = Math.min(m, i+k), c2 = Math.min(n, j+k);
                ans[i-1][j-1] = psa[r2][c2] - psa[r1-1][c2] - psa[r2][c1-1] + psa[r1-1][c1-1];
            }
        }
        return ans;
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