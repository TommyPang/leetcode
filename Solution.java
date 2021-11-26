import java.util.*;
import java.util.Deque;

class Solution {

    int [] dp = new int[1<<17];
    public int countArrangement(int n) {
        Arrays.fill(dp, -1);
        dp[(1<<n+1)-1] = 1;
        return dfs(1, n, 1);
    }
    public int dfs(int mask, int n, int v) {
        if (dp[mask]!=-1) return dp[mask];
        int ret = 0;
        for (int i = 1; i<=n; i++) {
            if (((mask>>i) & 1) != 1) {
                if (i%v==0 || v%i==0) {
                    ret += dfs(mask|(1<<i), n, v+1);
                }
            }
        }
        dp[mask] = ret;
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