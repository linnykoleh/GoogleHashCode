package structure;

import java.util.List;

public class Endpoint {

    private int dataCenterLatency;
    private int connectedCache;
    private List<LatencyEndpoint> latencyEndpointList;

    public Endpoint(int dataCenterLatency, int connectedCache, List<LatencyEndpoint> latencyEndpointList) {
        this.dataCenterLatency = dataCenterLatency;
        this.connectedCache = connectedCache;
        this.latencyEndpointList = latencyEndpointList;
    }

    public int getDataCenterLatency() {
        return dataCenterLatency;
    }

    public int getConnectedCache() {
        return connectedCache;
    }

    public List<LatencyEndpoint> getLatencyEndpointList() {
        return latencyEndpointList;
    }
}
