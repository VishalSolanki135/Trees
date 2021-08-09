class BinaryTree {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left=right=null;
        }
    }
    static Node root;
    BinaryTree(){
        root=null;
    }
    static void insert(int key) {
        root=insertUtil(root, key);
    }

    static Node insertUtil(Node root, int key) {
        if(root==null) {
            root=new Node(key);
            return root;
        }
        if(key<root.data) {
            root.left=insertUtil(root.left, key);
        } else if(key>root.data) {
            root.right=insertUtil(root.right, key);
        }
        //return the unchanged node pointer!!
        return root;
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

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.inOrder();
    }
}