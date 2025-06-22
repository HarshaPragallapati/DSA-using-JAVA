package binarySearch;

public class PeakElementOfMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1,4},{3,2}};
        int[] peak = findPeakGrid(mat);
        System.out.println(peak[0] + " " + peak[1]);
    }

    private static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = mat[0].length;
        while (low <= high){
            int mid = (low + high) / 2;
            int maxRowIndex = findMax(mat, n, m, mid);
            int left = mid - 1 >= 0 ? mat[maxRowIndex][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxRowIndex][mid + 1] : -1;
            if (mat[maxRowIndex][mid] > left && mat[maxRowIndex][mid] > right){
                return new int[]{maxRowIndex, mid};
            }
            else if (mat[maxRowIndex][mid] < left){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }

    private static int findMax(int[][] mat, int n, int m, int col) {
        int max = -1, index = -1;
        for (int i = 0; i < n; i++) {
            if(mat[i][col] > max){
                max = mat[i][col];
                index = i;
            }
        }
        return index;
    }
}
