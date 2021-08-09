class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}

class BinarySearchTree {
    static Node root;

    BinarySearchTree() {
        root=null;
    }

    static void delete(int key) {
        root=deleteUtil(root, key);
    }

    static Node deleteUtil(Node node, int key) {
        if(node==null) {
            return null;
        }

        if(key<node.data) {
            node.left=deleteUtil(node.left, key);
        } else if(key>node.data) {
            node.right=deleteUtil(node.right, key);
        } else {
            //the case where the data to be deleted is found.
            if(node.left!=null&&node.right!=null) {
                int lmax = findMax(node.left);
                node.data=lmax;
                node.left=deleteUtil(node.left, lmax);
                return node;
            } else if(node.left!=null) {
                return node.left;
            } else if(node.right!=null) {
                return node.right;
            } else {
                return null;
            }
        }
        return node;
    }

    static int findMax(Node node) {
        if(node.right!=null) {
            return findMax(node.right);
        } else {
            return node.data;
        }
    }
    void insert(int key) { root = insertRec(root, key); }

    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, int key)
    {

        /* If the tree is empty,
          return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() { inorderRec(root); }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println(
                "Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.delete(20);
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.delete(30);
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.delete(50);
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();
    }
}