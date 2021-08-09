class Node {
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    static int maxL;
    static int maxS;

    static void sumOfNode(Node node, int sum, int len) {
        if(node==null) {
            if(maxL<len) {
                maxL=len;
                maxS=sum;
            } else if(maxL==len&&maxS<sum) {
                maxS=sum;
            }
            return;
        }

        sumOfNode(node.left, sum+node.data, len+1);
        sumOfNode(node.right, sum+node.data, len+1);
    }

    static int totalSum(Node root) {
        if (root==null)return 0;
        maxS=Integer.MAX_VALUE;
        maxL=0;
        sumOfNode(root, 0, 0);
        return maxS;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left=new Node(2);
        root.right=new Node(5);
        root.left.left=new Node(7);
        root.left.right=new Node(1);
        root.right.left=new Node(2);
        root.right.right=new Node(3);
        root.left.right.left=new Node(6);

        System.out.println(totalSum(root));
    }
}
