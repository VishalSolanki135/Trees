public class BinarySearchTree {
    static class Interval {
        int low, high;
    }

    static class TNode {
        Interval i;
        int max;
        TNode left, right;
    }

    //Utility function to create a Node
    static Interval newNode(int l, int h) {
        Interval temp = new Interval();
        temp.low = l;
        temp.high = h;
        return temp;
    }

    //Utility function to create a Node
    static TNode newNode(Interval i) {

    }
}
