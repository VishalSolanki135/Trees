import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] a = {8, 6, 9, 5, 10, 7, 11};
        System.out.println(minSwaps(a));
    }

    static int minSwaps(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);

        boolean visited[] = new boolean[len];
        Arrays.fill(visited, false);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if(visited[i] || map.get(nums[i]) == i) {
                continue;
            }
            int j = i, swap=0;
            while(!visited[j]) {
                visited[j]=true;
                j = map.get(nums[j]);
                swap++;
            }
            if(swap > 0) {
                ans += (swap - 1);
            }
        }
        return ans;
    }
}
