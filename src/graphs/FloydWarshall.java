package graphs;

public class FloydWarshall {
    public static void main(String[] args) {
        int INF = (int) 1e8;
        int[][] dist = {
                {0, 4, INF, 5, INF},
                {INF, 0, 1, INF, 6},
                {2, INF, 0, 3, INF},
                {INF, INF, 1, 0, 2},
                {1, INF, INF, 4, 0}
        };

        floydWarshall(dist);
    }

    private static void floydWarshall(int[][] dist) {
        int n = dist.length;
        int INF = (int) 1e8;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
}
