class Node {
    int data;
    Node left, right;
    Node(int d){
        data = d;
        left = right = null;
    }
}

public class BinaryTree {
    static Node root;

    static boolean isSumTree(Node node) {
        if(node==null || (node.left==null && node.right==null)) return true;

        if((node.data == sum(node.left) + sum(node.right)) && isSumTree(node.left) && isSumTree(node.right)) return true;
        else return false;
    }

    static int sum(Node node) {
        if(node == null) return 0;
        System.out.println(sum(node.left) + node.data + sum(node.right));
        return (sum(node.left) + node.data + sum(node.right));
    }

    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        tree.root=new Node(26);
        tree.root.left=new Node(10);
        tree.root.right=new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(6);
        tree.root.right.right=new Node(3);
        if(isSumTree(root))
        {
            System.out.println("The given tree is a SumTree");
        }
        else
        {
            System.out.println("The given tree is not a SumTree");
        }
    }
}
