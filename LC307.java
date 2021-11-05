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
        //singleNumber(new int[]{2,2,3,2});
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
    class NumArray {
        int [] segTree;
        int n;
        public NumArray(int[] nums) {
            n = nums.length;
            int height = (int) Math.ceil(Math.log(n)/Math.log(2)) + 1;
            int size = (int) (Math.pow(2, height) - 1);
            segTree = new int[size+1];
            construct(0, n-1, nums, 1);
        }

        public void update(int index, int val) {
            update(0, n-1, index, 1, val);
        }

        public int sumRange(int left, int right) {
            return query(left+1, right+1, 1, 0, n-1);
        }

        public int construct(int start, int end, int [] arr, int idx) {
            if (start==end) { segTree[idx] = arr[start]; return segTree[idx]; }
            int mid = (start+end)/2;
            segTree[idx] =  construct(start, mid, arr, 2*idx) + construct(mid+1, end, arr, 2*idx+1);
            return segTree[idx];
        }

        public int query(int qs, int qe, int idx, int start, int end) {
            if (qe<start || qs>end) return 0;
            if (qs<=start && qe>=end) return segTree[idx];
            int mid = (start+end)/2;
            return query(qs, qe, 2*idx, start, mid) + query(qs, qe, 2*idx+1, mid+1, end);
        }

        public int update(int start, int end, int idxToUpdate, int idx, int v) {
            if (idxToUpdate<start || idxToUpdate>end) return segTree[idx];
            if (idxToUpdate==start && idxToUpdate==end) {
                segTree[idx] = v;
                return segTree[idx];
            }
            int mid = (start+end)/2;
            segTree[idx] = update(start, mid, idxToUpdate, idx, v) + update(mid+1, end, idxToUpdate, idx, v);
            return segTree[idx];
        }
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
