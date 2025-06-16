package arrays;

public class SetMatrixZeroes73 {
    public static void main(String[] args) {
        int[][] mat = {{1,1,1},{1,0,1},{1,1,1}};
        int n = mat.length;
        int m = mat[0].length;
        int c = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                if (mat[i][j] == 0){
                    mat[i][0] = 0;
                    if (j != 0){
                        mat[0][j] = 0;
                    }
                    else {
                        c = 0;
                    }
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++){
                if(mat[i][j] != 0){
                    if (mat[i][0] == 0 || mat[0][j] == 0){
                        mat[i][j] = 0;
                    }
                }
            }
        }

        if (mat[0][0] == 0){
            for (int j = 1; j < m; j++) {
                mat[0][j] = 0;
            }
        }

        if (c == 0){
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
