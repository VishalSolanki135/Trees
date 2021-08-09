class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Node node = new Node(60);
        node.left = new Node(65);
        node.right = new Node(70);
        node.left.left = new Node(50);
        System.out.println(largestBst2(node));
    }

    static int max = Integer.MAX_VALUE;
    static int min = Integer.MIN_VALUE;

    static class NodeVariables {
        int isBST;
        int size;
        int max;//min value in subtree
        int min;//max value in subtree
        int ans;

        NodeVariables() {}

        NodeVariables(int isBST, int size, int max, int min, int ans) {
             this.isBST = isBST;
             this.size = size;
             this.min = min;
             this.max = max;
             this.ans =ans;
        }
    }

    static NodeVariables largestBst(Node root) {
        //base cases
        if(root==null) return new NodeVariables(1, 0, min, max, 0);
        if(root.left==null&&root.right==null) return new NodeVariables(1, 1, root.data, root.data, 1);

        //recursion for left and right subtrees
        NodeVariables left = largestBst(root.left);
        NodeVariables right = largestBst(root.right);

        NodeVariables returnVariable = new NodeVariables();
        returnVariable.size = 1 + left.size + right.size;

        if(left.isBST==1&&right.isBST==1 && left.max<root.data&&right.min>root.data) {
            returnVariable.min = Math.min(Math.min(left.min, right.min), root.data);
            returnVariable.max = Math.max(Math.max(left.max, right.max), root.data);

            returnVariable.ans=returnVariable.size;
            returnVariable.isBST=1;
        }
        returnVariable.size=Math.max(left.ans, right.ans);
        returnVariable.isBST=0;
        return returnVariable;
    }
    static int largestBst2(Node root)
    {
        return largestBst(root).size;
    }
}
