package graphs;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int result = numEnclaves(grid);
        System.out.println(result);
    }

    private static int numEnclaves(int[][] grid) {
        // using in-place
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][n - 1] == 1) {
                dfs(grid, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j);
            }
            if (grid[m - 1][j] == 1) {
                dfs(grid, m - 1, j);
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != 1) {
            return;
        }
        grid[row][col] = 0;
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
