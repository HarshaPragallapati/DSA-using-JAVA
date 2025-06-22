package graphs;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int num = numIslands(grid);
        System.out.println(num);
    }

    private static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1'){
                    count++;
                    bfs(grid, row, col);
                }
            }
        }
        return count;
    }

    private static void bfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != '1') return;
        grid[row][col] = '0';
        bfs(grid, row + 1, col);
        bfs(grid, row - 1, col);
        bfs(grid, row, col + 1);
        bfs(grid, row, col - 1);
    }
}

