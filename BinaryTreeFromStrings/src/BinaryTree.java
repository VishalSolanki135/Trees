import java.util.Stack;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}

public class BinaryTree {
    static int findIndex(String str, int si, int ei) {
        if(si>ei) return -1;

        Stack<Character> stack = new Stack<>();
        for (int i = si; i <= ei; i++) {
            if(str.charAt(i)=='(') stack.add(str.charAt(i));
            else if(str.charAt(i)==')') {
                if(stack.peek()=='('){
                    stack.pop();
                    if(stack.isEmpty()) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    static Node treeFromString(String str, int si, int ei) {
        if(si>ei) return null;

        Node root = new Node(str.charAt(si) - '0');
        int index = -1;

        if(si+1 <=ei && str.charAt(si+1)=='(') {
            index = findIndex(str, si+1, ei);
        }

        if(index!=-1){
            root.left = treeFromString(str, si+2 ,index-1);
            root.right = treeFromString(str, index+2, ei-1);
        }
        return root;
    }

    static void printPreOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {
        String str = "4(2(3)(1))(6(5))";
        Node root = treeFromString(str, 0, str.length()-1);
        printPreOrder(root);
    }
}
