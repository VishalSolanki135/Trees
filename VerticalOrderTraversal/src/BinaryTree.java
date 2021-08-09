import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Node {
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left=right=null;
    }
}

public class BinaryTree {
    static void getVerticalOrder(Node root, int hd, TreeMap<Integer, List<Integer>> map) {
        if(root==null) return;
        List<Integer> get = map.get(hd);//give the value at specified key!
        if(get==null) {
            get=new ArrayList<>();
            get.add(root.data);
        } else{
            get.add(root.data);
        }

        map.put(hd, get);

        getVerticalOrder(root.left, hd-1, map);
        getVerticalOrder(root.right, hd+1, map);
    }


    //function to print the vertical order
    static void printVerticalOrder(Node root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int hd = 0;
        getVerticalOrder(root, hd, map);
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {

        // TO DO Auto-generated method stub
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }
}
