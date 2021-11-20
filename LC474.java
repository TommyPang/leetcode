import java.util.*;
import java.util.Deque;

class Solution {

    public static void main(String[] args) {
        Node fir = new Node(7);
        fir.next = new Node(13);
        fir.next.random = fir;
        fir.next.next = new Node(11);
        fir.next.next.next = new Node(10);
        fir.next.next.next.random = fir.next.next;
        fir.next.next.next.next = new Node(1);
        fir.next.next.next.next.random = fir;
        fir.next.next.random = fir.next.next.next.next;
        ListNode sec = new ListNode(1);
        sec.next = new ListNode(2);
        sec.next.next = new ListNode(3);
        sec.next.next.next = new ListNode(4);
        sec.next.next.next.next = new ListNode(5);
        TreeNode forth = new TreeNode(3);
        forth.left = new TreeNode(1);
        forth.right = new TreeNode(4);
        forth.left.right = new TreeNode(2);
        forth.right.right = new TreeNode(5);
        Solution s = new Solution();

    }
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int [][][] dp = new int[len+1][m+1][n+1];
        int [] cntZero = new int[len+1], cntOne = new int[len+1];
        for (int i = 1; i<=len; i++) {
            int zero = 0, one = 0;
            for (int j = 0; j<strs[i-1].length(); j++) {
                char temp = strs[i-1].charAt(j);
                if (temp == '0') zero++;
                else one++;
            }
            cntZero[i] = zero; cntOne[i] = one;
            if (zero<=m && one<=n) {
                dp[i][zero][one] = 1;
            }
        }
        int ans = 0;
        for (int k = 1; k<=len; k++) {
            int zero = cntZero[k], one = cntOne[k];
            for (int i = 0; i<=m; i++) {
                for (int j = 0; j<=n; j++) {
                    dp[k][i][j] = dp[k-1][i][j];
                    if (i<zero || j<one) continue;
                    dp[k][i][j] = Math.max(dp[k-1][i-zero][j-one] + 1, dp[k][i][j]);
                    if (ans<dp[k][i][j]) {
                        ans = dp[k][i][j];
                    }
                }
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
