class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}

public class BinarySearchTree {
    static Node root;
    static void insert(int data) {
        root=insertRec(root, data);
    }

    static Node insertRec(Node root, int data) {
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(data<root.data) {
            root.left = insertRec(root.left, data);
        } else if(data>root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    static boolean containsDeadEnd(Node root, int min, int max) {
        if(root==null) {
            return false;
        }
        if(min==max) return true;
        return (containsDeadEnd(root.left, min, root.data-1) || containsDeadEnd(root.right, root.data+1, max));
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(8);
        tree.insert(5);
        tree.insert(2);
        tree.insert(3);
        tree.insert(7);
        tree.insert(11);
        tree.insert(4);

        if(containsDeadEnd(tree.root, 1, Integer.MAX_VALUE) == true) {
            System.out.println("Yes, It contains dead end!");
        } else {
            System.out.println("No it does not containds dead end");
        }
    }
}
