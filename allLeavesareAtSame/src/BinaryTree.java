class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class LeafLevel {
    int leafLevel = 0;
}
public class BinaryTree {
    static Node root;
    static LeafLevel leafLevel = new LeafLevel();//level of the first leaf node.

    static boolean check(Node node, int level, LeafLevel leafLevel){
        if(node==null) return true;
        //a leaf node is encountered
        if(node.left==null && node.right==null) {
            //if first time a leaf node is encountered.
            if(leafLevel.leafLevel==0) {
                leafLevel.leafLevel = level;
                return true;
            }
            return level==leafLevel.leafLevel;
        }
        //if this node is not leaf, keep on checking the leaf node recursively!!
        return check(node.left, level+1, leafLevel) && check(node.right, level+1, leafLevel);
    }

    static boolean check1(Node root) {
        int level = 0;
        return check(root, level, leafLevel);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(12);
        tree.root.left = new Node(5);
        tree.root.right = new Node(7);
        tree.root.left.right = new Node(3);
        if(check1(root)) {
            System.out.println("At Same Level");
        } else {
            System.out.println("Not At Same Level");
        }
    }
}
