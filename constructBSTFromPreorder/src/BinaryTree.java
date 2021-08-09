class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;

    }
}

class Index {
    int index = 0;
}

public class BinaryTree {
    static Index index = new Index();

    static Node bstPreOrder(int[] pre, Index preIndex,int key, int min, int max, int size){
        //base case
        if(preIndex.index>=size) return null;

        Node root = null;
        if(key>min&&key<max) {
            root = new Node(key);
            preIndex.index=preIndex.index+1;
            if(preIndex.index<size) {
                root.left=bstPreOrder(pre, preIndex, pre[preIndex.index], min, key, size);
            }
            if(preIndex.index<size){
                root.right=bstPreOrder(pre, preIndex, pre[preIndex.index], key, max, size);
            }
        }
        return root;
    }

    static Node constructTree(int[] pre, int size) {
        int preIndex=0;
        return bstPreOrder(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }

    static void printInorder(Node node) {
        if(node==null) return;
        printInorder(node.left);
        System.out.println(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
        int size = pre.length;

        // Function call
        Node root = tree.constructTree(pre, size);
        System.out.println(
                "Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }

}
