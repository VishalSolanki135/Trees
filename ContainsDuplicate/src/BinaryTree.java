import java.util.HashSet;

class Node {
    int data;
    Node left,right;
    Node(int data)
    {
        this.data=data;
    }
}

class BinaryTree {
    static char mark='$';
    static String dupSubtreeUtil(Node root, HashSet<String> subtrees) {
        String s = "";
        if(root==null) return s + mark;

        String leftStr = dupSubtreeUtil(root.left, subtrees);
        if(leftStr.equals(s)) {
            return s;
        }
        String rightStr = dupSubtreeUtil(root.right, subtrees);
        if(rightStr.equals(s)) {
            return s;
        }

        s = s + root.data + leftStr + rightStr;

        if(s.length()>3&&subtrees.contains(s)) {
            return "";
        }
        subtrees.add(s);
        return s;
    }

    static String dupSub(Node root) {
        HashSet<String> hashSet = new HashSet<>();
        return dupSubtreeUtil(root, hashSet);
    }

    public static void main(String[] args) {
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');
        root.left.left = new Node('D');
        root.left.right = new Node('E');
        root.right.right = new Node('B');
        root.right.right.right = new Node('E');
        root.right.right.left= new Node('D');
        String str = dupSub(root);
        if(str.equals(""))
            System.out.print(" Yes ");
        else
            System.out.print(" No ");
    }
}