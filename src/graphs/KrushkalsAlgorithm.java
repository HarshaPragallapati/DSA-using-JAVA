package graphs;

import java.util.Arrays;
import java.util.Comparator;

public class KrushkalsAlgorithm {
    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {{0,1,5},{1,2,3},{0,2,1}};
        System.out.println(kruskalsMST(V, edges));
    }

    private static int kruskalsMST(int V, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        DisjointSet ds = new DisjointSet(V);
        int mstWeight = 0;
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if (ds.findUPar(u) != ds.findUPar(v)){
                ds.unionByRank(u, v);
                mstWeight += wt;
            }
        }
        return mstWeight;
    }
}
