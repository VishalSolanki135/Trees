import java.util.Stack;

public class NGE {
    static Stack<Integer> stack=new Stack<>();
    static void printNGE(int n, int[] arr) {
        stack.push(arr[0]);
        int next, element;
        for (int i = 1; i < n; i++) {
            next = arr[i];
            if(!stack.isEmpty()) {
                element=stack.pop();
                while(element<next) {
                    System.out.println(element + " = " + next);
                    if(stack.isEmpty()==true) break;
                    element=stack.pop();
                }
                if(element>next) {
                    stack.push(element);
                }
            }
            stack.push(next);
        }
        while(!stack.isEmpty()) {
            element = stack.pop();
            next=-1;
            System.out.println(element + " = " + next);
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 13, 21, 3};
        int n = arr.length;
        printNGE(n, arr);
    }
}
