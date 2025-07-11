import java.util.Arrays;

class Bellmanford {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        
        // Initially distance from source to all other vertices 
        // is not known(Infinite).
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;

        // Relaxation of all the edges V times, not (V - 1) as we  
        // need one additional relaxation to detect negative cycle
        for (int i = 0; i < V; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    
                    // If this is the Vth relaxation, then there is
                    // a negative cycle
                    if (i == V - 1)
                        return new int[]{-1};
                    
                    // Update shortest distance to node v
                    dist[v] = dist[u] + wt;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        
    // Number of vertices in the graph
    int V = 5;

    // Edge list representation: {source, destination, weight}
    int[][] edges = new int[][] {
        {1, 3, 2},    
        {4, 3, -1},   
        {2, 4, 1},    
        {1, 2, 1},    
        {0, 1, 5}     
    };

    // Source vertex for Bellman-Ford algorithm
    int src = 0;

    // Run Bellman-Ford algorithm from the source vertex
    int[] ans = bellmanFord(V, edges, src);

    // Print shortest distances from the source to all vertices
    for (int dist : ans) 
        System.out.print(dist + " ");
}
}