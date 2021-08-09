import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;

    }
}

class QObj {
    Node node;
    int hd;

    QObj(Node node, int hd)
    {
        this.node = node;
        this.hd = hd;
    }
}

class BinaryTree {
    static Node root;

    static void topView(Node root) {
        if (root == null) {
            return;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int hd = 0;//horizontal distance
        Queue<QObj> queue = new LinkedList<>();
        queue.add(new QObj(root, 0));

        while (!queue.isEmpty()) {
            QObj temp = queue.poll();
            hd = temp.hd;
            Node node = temp.node;

            if(!map.containsKey(hd)) {
                List<Integer> list = new ArrayList<>();
                list.add(node.data);
                map.put(hd, list);
            }

            if(node.left!=null) {
                queue.add(new QObj(node.left, hd-1));
            }

            if(node.right!=null) {
                queue.add(new QObj(node.right, hd+1));
            }
        }
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> list = entry.getValue();
            for(Integer i: list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        System.out.println("Vertical order traversal is ");

        topView(root);
    }
}