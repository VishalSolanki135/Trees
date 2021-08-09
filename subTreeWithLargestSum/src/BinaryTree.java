class Node {
    int data;
    Node left,right;

    Node(int d) {
        data = d;
        left=right=null;
    }
}



public class BinaryTree {
    static int maxSum;

    static class Value{
        int max;
        Value(int max) {
            this.max = max;
        }
    }
    static int largestSum(Node root, Value maxSum) {
        if(root==null) return 0;

        int temp = root.data + largestSum(root.left, maxSum) + largestSum(root.right, maxSum);

        maxSum.max=Math.max(maxSum.max, temp);
        return temp;
    }

    static int sum(Node root) {
        if(root==null) {
            return 0;
        }


        Value maxSum = new Value(-1);
        largestSum(root, maxSum);
        return maxSum.max;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(-2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(-6);
        root.right.right = new Node(2);

        System.out.println(sum(root));
    }
}
