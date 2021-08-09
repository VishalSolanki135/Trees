import com.sun.source.tree.Tree;
import org.w3c.dom.ls.LSException;

import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Qobj {
    int hd = 0;
    Node node;
    Qobj(int hd, Node node) {
        this.hd = hd;
        this.node = node;
    }
}

public class BinaryTree {
    static Node root;
    static void bottomView(Node root) {
        if (root==null) return;

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int hd = 0;
        Queue<Qobj> queue = new LinkedList<>();
        queue.add(new Qobj(0, root));

        while (!queue.isEmpty()) {
            Qobj temp = queue.poll();
            hd = temp.hd;
            Node node = temp.node;

            map.put(hd, node.data);

            if(node.left!=null) {
                queue.add(new Qobj(hd-1, node.left));
            }
            if(node.right!=null) {
                queue.add(new Qobj(hd+1, node.right));
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Integer value = entry.getValue();
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println("Vertical order traversal is ");
        bottomView(root);
    }
}
