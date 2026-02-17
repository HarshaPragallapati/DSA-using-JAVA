package trees;

import java.util.ArrayList;
import java.util.List;

public class CreateComponentsWithSameValue {

    static boolean isPossible;

    public static void main(String[] args) {
        int[] nums = {6, 2, 2, 2, 6};
        int[][] edges = {{0,1},{1,2},{1,3},{3,4}};
        System.out.println(componentValue(nums, edges));
    }

    private static int componentValue(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int total = 0;
        for (int num : nums){
            total += num;
        }
        for (int k = n; k > 0; k--) {
            if (total % k != 0) continue;
            int target = total / k;
            isPossible = true;
            if (dfs(adj, nums, target, 0, -1) == 0 && isPossible){
                return k - 1;
            }
        }
        return 0;
    }

    private static int dfs(List<List<Integer>> adj, int[] nums, int target, int node, int parent) {
        int sum = nums[node];
        for (int nei : adj.get(node)){
            if (nei == parent) continue;
            sum += dfs(adj, nums, target, nei, node);
        }
        if (sum == target) return 0;
        if (sum > target) isPossible = false;
        return sum;
    }
}
