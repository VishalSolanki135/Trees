import java.util.HashMap;

class Node {
    int data;
    Node left,right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}

public class BinaryTree {
    static int sumOfGrandChildren(Node node, HashMap<Node, Integer> mp) {
        int sum = 0;
        //  call for children of left child only if it is not NULL
        if (node.left!=null)
            sum += getMaxSumUtil(node.left.left, mp) +
                    getMaxSumUtil(node.left.right, mp);

        //  call for children of right child only if it is not NULL
        if (node.right!=null)
            sum += getMaxSumUtil(node.right.left, mp) +
                    getMaxSumUtil(node.right.right, mp);
        return sum;
    }

    static int getMaxSumUtil(Node root, HashMap<Node, Integer> map) {
        if(root==null) {
            return 0;
        }
        if(map.containsKey(root)) return map.get(root);

        //call for only node value and not for its children
        int nv = root.data + sumOfGrandChildren(root, map);

        //call for only children and not for root node.
        int cv = getMaxSumUtil(root.left, map) + getMaxSumUtil(root.right, map);

        map.put(root, Math.max(nv, cv));

        return map.get(root);
    }

    static int maxSum(Node root) {
        if(root==null) return 0;
        HashMap<Node, Integer> map = new HashMap<>();
        return getMaxSumUtil(root, map);
    }

    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.left.left = new Node(1);
        System.out.print(maxSum(root));
    }
}
