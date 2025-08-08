package graphs;

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(removeStones(stones));
    }

    private static int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for (int[] stone : stones){
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        Set<Integer> nodes = new HashSet<>();
        for (int[] stone : stones){
            int row = stone[0];
            int col = stone[1] + maxRow + 1;
            ds.unionBySize(row, col);
            nodes.add(row);
            nodes.add(col);
        }
        int cnt = 0;
        for (int num : nodes){
            if (ds.findUPar(num) == num){
                cnt++;
            }
        }
        return stones.length - cnt;
    }
}
