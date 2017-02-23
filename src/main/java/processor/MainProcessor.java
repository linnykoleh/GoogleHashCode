package processor;

import provider.EndpointProvider;
import provider.RequestsProvider;
import provider.VideoProvider;
import structure.EnterDataInfo;
import structure.Graph;

import static alghoritm.AlgorithmFordBellman.BellmanFord;


public class MainProcessor {

    private EnterDataInfo info;
    private VideoProvider videoProvider;
    private static EndpointProvider endpointProvider;
    private RequestsProvider requestsProvider;

    public MainProcessor(EnterDataInfo info, VideoProvider videoProvider, EndpointProvider endpointProvider, RequestsProvider requestsProvider) {
        this.info = info;
        this.videoProvider = videoProvider;
        MainProcessor.endpointProvider = endpointProvider;
        this.requestsProvider = requestsProvider;
    }

    public static void main(String[] args) {
        int V = endpointProvider.getNumberOfEndpoints();  // Number of vertices in graph
        int E = 8;  // Number of edges in graph

        Graph graph = new Graph(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        BellmanFord(graph, 0);
    }
    }

