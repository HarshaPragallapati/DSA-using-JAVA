package graphs;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        for (char[] arr : board) {
            for (char ch : arr) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    private static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(board, visited, i, 0);
            }
            if (board[i][n - 1] == 'O' && !visited[i][n - 1]) {
                dfs(board, visited, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                dfs(board, visited, 0, j);
            }
            if (board[m - 1][j] == 'O' && !visited[m - 1][j]) {
                dfs(board, visited, m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(char[][] board, boolean[][] visited, int row, int col) {
        int m = board.length;
        int n = board[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != 'O' || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        dfs(board, visited, row + 1, col);
        dfs(board, visited, row - 1, col);
        dfs(board, visited, row, col + 1);
        dfs(board, visited, row, col - 1);
    }
}
