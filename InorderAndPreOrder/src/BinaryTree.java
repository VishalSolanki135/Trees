import java.util.HashMap;

class Node
{
    char data;
    Node left,right;
    Node(char item)
    {
        data = item;
        left = right = null;
    }
}
public class BinaryTree {
    static Node root;
    static HashMap<Character, Integer> map = new HashMap<>();
    static int preIndex = 0;

    static Node buildTree(char[] in, char[] pre, int instrt, int inEnd) {
        if(instrt > inEnd) return null;
        char curr = pre[preIndex++];
        Node newNode = new Node(curr);
        if(instrt==inEnd) {
            return newNode;
        }

        int inIndex = map.get(curr);
        newNode.left = buildTree(in, pre, instrt, inIndex-1);
        newNode.right = buildTree(in, pre, inIndex+1, inEnd);
        return newNode;
    }

    static Node buildWrap(char[] in, char[] pre, int len) {
        for (int i = 0; i < len; i++) {
            map.put(in[i], i);
        }
        return buildTree(in, pre, 0, len-1);
    }
}
