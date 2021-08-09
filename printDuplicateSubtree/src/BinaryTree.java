import java.util.HashMap;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    static String printAllDup(Node node, HashMap<String, Integer> map) {
        if (node==null) return "";
        String str = "(";
        str += printAllDup(node.left, map);
        str+=Integer.toString(node.data);
        str+=printAllDup(node.right, map);
        str+=")";

        if(map.get(str)!=null && map.get(str)==1) {
            System.out.println(node.data + " ");
        }
        if(map.containsKey(str)) map.put(str, map.get(str)+1);
        else map.put(str, 1);
        return str;
    }

    static void printAllDups(Node root)
    {
        HashMap map = new HashMap<>();
        printAllDup(root, map);
    }

    public static void main(String args[])
    {
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        printAllDups(root);
    }
}
