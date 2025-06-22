package backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    private static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)){
                    if (searchNext(board, word, i, j, 0, m, n)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean searchNext(char[][] board, String word, int row, int col, int index, int m, int n) {
        if (index == word.length()){
            return true;
        }
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != word.charAt(index) || board[row][col] == '!'){
            return false;
        }
        char ch = board[row][col];
        board[row][col] = '!';
        boolean top = searchNext(board, word, row - 1, col, index + 1, m, n);
        boolean down = searchNext(board, word, row + 1, col, index + 1, m, n);
        boolean right = searchNext(board, word, row, col + 1, index + 1, m, n);
        boolean left = searchNext(board, word, row, col - 1, index + 1, m, n);
        board[row][col] = ch;
        return top || down || left || right;
    }
}
