class Node {
    int data;
    Node left, right, parent;
    Node(int data) {
        this.data = data;
        left=right=parent=null;
    }
}

public class BinaryTree {
    static Node root;

    static Node insert(Node node, int key) {
        if(node==null) return (new Node(key));
        else {
            Node temp = null;
            if (key < node.data) {
                temp = insert(node.left, key);
                node.left = temp;
                temp.parent = node;
            } else {
                temp=insert(node.right, key);
                node.right=temp;
                temp.parent=node;
            }
        }
        return node;
    }

    static Node inOrderPredecessor(Node root, Node node) {
        if(node.left!=null) {
            return findMax(node.left);
        }

        Node parent = node.parent;
        while(parent!=null && node==parent.left) {
            node = parent;
            parent=parent.parent;
        }
        return parent;
    }

    static Node findMax(Node node) {
        if(node.right!=null) {
            return findMax(node.right);
        }
        return node;
    }

    static void inOrder() {
        inOrderUtil(root);
    }

    static void inOrderUtil(Node root) {
        if(root!=null) {
            inOrderUtil(root.left);
            System.out.println(root.data);
            inOrderUtil(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);

        temp = root.left.right.left;
        suc = tree.inOrderPredecessor(root, temp);
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
