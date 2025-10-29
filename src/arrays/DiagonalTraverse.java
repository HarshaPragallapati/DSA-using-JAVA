package arrays;

public class DiagonalTraverse {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[] result = findDiagonalOrder(mat);
        for (int num : result){
            System.out.print(num + " ");
        }
    }

    private static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int row = 0, col = 0;
        int dir = 1;
        for (int i = 0; i < m * n; i++) {
            ans[i] = mat[row][col];
            if (dir == 1){
                if (col == n - 1){
                    row++;
                    dir = 0;
                } else if (row == 0) {
                    col++;
                    dir = 0;
                } else {
                    row--;
                    col++;
                }
            }
            else {
                if (row == m - 1) {
                    col++;
                    dir = 1;
                } else if (col == 0){
                    row++;
                    dir = 1;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return ans;
    }
}
