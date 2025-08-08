package graphs;

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
    public static void main(String[] args) {
        int[][] grid = {{1,0},{0,1}};
        System.out.println(largestIsland(grid));
    }

    private static int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) continue;
                for (int i = 0; i < 4; i++) {
                    int adjR = row + dr[i];
                    int adjC = col + dc[i];
                    if (isValid(adjR, adjC, n) && grid[adjR][adjC] == 1){
                        int node = row * n + col;
                        int adjNode = adjR * n + adjC;
                        ds.unionBySize(node, adjNode);
                    }
                }
            }
        }
        int mx = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;
                Set<Integer> components = new HashSet<>();
                for (int i = 0; i < 4; i++) {
                    int adjR = row + dr[i];
                    int adjC = col + dc[i];
                    if (isValid(adjR, adjC, n)){
                        if (grid[adjR][adjC] == 1){
                            components.add(ds.findUPar(adjR * n + adjC));
                        }
                    }
                }
                int total = 1;
                for (Integer parent : components){
                    total += ds.size[parent];
                }
                mx = Math.max(mx, total);
            }
        }
        for (int cell = 0; cell < n * n; cell++) {
            mx = Math.max(mx, ds.size[ds.findUPar(cell)]);
        }
        return mx;
    }

    private static boolean isValid(int adjr, int adjc, int n) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < n;
    }
}
