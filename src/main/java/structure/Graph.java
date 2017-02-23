package structure;

/**
 * Created by artem on 2/23/17.
 */
public class Graph {

    public int V;
    public int E;
    public Edge[] edge;

    public class Edge {
        public int src;
        public int dest;
        public int weight;
        Edge() {
            src = dest = weight = 0;
        }
    };

    public Graph(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
}
