package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        int num = countDistinctIslands(grid);
        System.out.println(num);
    }

    private static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        HashSet<String> shapes = new HashSet<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    List<String> shape = new ArrayList<>();
                    dfs(grid, visited, row, col, row, col, shape);
                    shapes.add(String.join(",", shape));
                }
            }
        }
        return shapes.size();
    }

    private static void dfs(int[][] grid, boolean[][] visited, int row, int col, int baseRow, int baseCol, List<String> shape) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length ||
                grid[row][col] == 0 || visited[row][col]) return;
        visited[row][col] = true;
        shape.add((row - baseRow) + ":" + (col - baseCol));
        dfs(grid, visited, row + 1, col, baseRow, baseCol, shape);
        dfs(grid, visited, row - 1, col, baseRow, baseCol, shape);
        dfs(grid, visited, row, col + 1, baseRow, baseCol, shape);
        dfs(grid, visited, row, col - 1, baseRow, baseCol, shape);
    }
}
