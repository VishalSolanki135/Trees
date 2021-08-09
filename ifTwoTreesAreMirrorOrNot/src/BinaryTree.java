class Node
{
    int data;
    Node left, right;

    public Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {
    Node a, b;
    static boolean isMirror(Node a, Node b) {
        if(a==null && b==null) return true;

        if(a==null||b==null) return false;

        return a.data==b.data && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);

        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(4)
        ;
        b.right.right = new Node(5);

        if(isMirror(a, b)) System.out.println("YES");
        else System.out.println("NO");
    }
}
