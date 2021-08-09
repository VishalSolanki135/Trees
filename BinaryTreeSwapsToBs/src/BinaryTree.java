import java.util.Arrays;
import java.util.HashMap;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}

class BinaryTree {
    static Node root;
    static int k=0;
    static HashMap<Integer, Integer> map = new HashMap<>();

    static void inOrder(int[] arr, HashMap<Integer, Integer> map, int n, int index) {
        if(index>=n) return;
        inOrder(arr, map, n, 2*index+1);
        map.put(arr[index], k);
        k++;
        inOrder(arr, map, n, 2*index+2);
    }

    static int minSwaps(int[] arr) {
        int n = arr.length;
        inOrder(arr, map, n, 0);
        Arrays.sort(arr);

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(visited[i] || map.get(arr[i])==i) continue;

            int j=i, swaps = 0;
            while(!visited[j]) {
                visited[j]=true;
                j = map.get(arr[j]);
                swaps++;
            }
            if(swaps>0) ans+=(swaps-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(minSwaps(arr));
    }
}