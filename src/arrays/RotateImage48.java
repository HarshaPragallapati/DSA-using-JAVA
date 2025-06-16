package arrays;

public class RotateImage48 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int m = matrix.length;
        int n = matrix[0].length;
        for (int[] mat : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m - j -1];
                matrix[i][m - j - 1] = temp;
            }
        }
        System.out.println("After rotating matrix by 90 degrees");
        for (int[] mat : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[j] + " ");
            }
            System.out.println();
        }
    }
}
