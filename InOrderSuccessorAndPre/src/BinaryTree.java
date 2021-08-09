class Node {
    int data;
    Node left, right, parent;
    Node(int data){
        this.data = data;
        left=right=parent=null;
    }
}

public class BinaryTree {
    static Node head;

    static Node insert(Node node, int data) {
        if(node==null) return (new Node(data));
        else {
            Node temp = null;
            if (data < node.data) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
            } else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }
        }
        return node;
    }

    static Node inOrderSuccessor(Node root, Node node) {
        //node is the node whose successor we have to find
        if(node.right!=null) {
            return findMin(node.right);
        }
        Node parent = node.parent;
        while(parent!=null && node==parent.right) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    static Node findMin(Node node){
        if(node.left!=null) {
            return findMin(node.left);
        }
        return node;
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        Node root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        temp = root.left.right.right;
        suc = tree.inOrderSuccessor(root, temp);
        if (suc != null) {
            System.out.println(
                    "Inorder successor of "
                            + temp.data + " is " + suc.data);
        }
        else {
            System.out.println(
                    "Inorder successor does not exist");
        }
    }
}
