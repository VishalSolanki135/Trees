import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}

class QNode {
    int hd;
    Node node;

    QNode(int hd, Node node) {
        this.hd = hd;
        this.node = node;
    }
}

public class BinaryTree {
    static Node root;

    static void diagonalTraversal(Node root) {
        if(root==null) return;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<QNode> queue = new LinkedList<>();
        queue.add(new QNode(0, root));

        while(!queue.isEmpty()) {
            QNode temp = queue.poll();
            map.putIfAbsent(temp.hd, new ArrayList<>());
            map.get(temp.hd).add(temp.node.data);

            if(temp.node.left!=null) {
                queue.add(new QNode(temp.hd+1, temp.node.left));
            }

            if(temp.node.right!=null) {
                queue.add(new QNode(temp.hd, temp.node.right));
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            int k = entry.getKey();
            List<Integer> list = map.get(k);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        diagonalTraversal(root);
    }
}
