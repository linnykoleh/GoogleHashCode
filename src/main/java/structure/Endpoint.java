package structure;

import java.util.List;

public class Endpoint {

    private int dataCenterLatency;
    private int connectedCache;
    private List<LatencyOfEndpoint> latencyOfEndpointList;

    public Endpoint(int dataCenterLatency, int connectedCache, List<LatencyOfEndpoint> latencyOfEndpointList) {
        this.dataCenterLatency = dataCenterLatency;
        this.connectedCache = connectedCache;
        this.latencyOfEndpointList = latencyOfEndpointList;
    }

    public int getDataCenterLatency() {
        return dataCenterLatency;
    }

    public int getConnectedCache() {
        return connectedCache;
    }

    public List<LatencyOfEndpoint> getLatencyOfEndpointList() {
        return latencyOfEndpointList;
    }
}
