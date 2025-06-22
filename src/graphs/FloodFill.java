package graphs;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        int[][] result = floodFill(image, sr, sc, color);
        for (int[] num : result) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(num[j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColour = image[sr][sc];
        if (startColour == color) return image;
        fill(image, sr, sc, startColour, color);
        return image;
    }

    private static void fill(int[][] image, int r, int c, int startColour, int color) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] !=startColour) return;
        image[r][c] = color;
        fill(image, r + 1, c, startColour, color);
        fill(image, r - 1, c, startColour, color);
        fill(image, r, c + 1, startColour, color);
        fill(image, r, c - 1, startColour, color);
    }
}
