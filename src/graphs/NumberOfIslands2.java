package graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {
    public static void main(String[] args) {
        int rows = 4, cols = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
                {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };
        List<Integer> result = numOfIslands(rows, cols, operators);
        System.out.println(result);
    }

    private static List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet ds = new DisjointSet(rows * cols);
        boolean[][] visited = new boolean[rows][cols];
        List<Integer> ans = new ArrayList<>();
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        int cnt = 0;
        int n = operators.length;
        for (int i = 0; i < n; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            if (visited[row][col]){
                ans.add(cnt);
                continue;
            }
            visited[row][col] = true;
            cnt++;
            for (int j = 0; j < 4; j++) {
                int newR = row + dr[j];
                int newC = col + dc[j];
                if (isValid(newR, newC, rows, cols)){
                    if (visited[newR][newC]){
                        int node = row * rows + col;
                        int adjNode = newR * rows + newC;
                        if (ds.findUPar(node) != ds.findUPar(adjNode)){
                            cnt--;
                            ds.unionBySize(node, adjNode);
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }

    private static boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }
}
