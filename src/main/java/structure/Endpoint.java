package structure;

import java.util.List;

public class Endpoint {

    private int endpointId;
    private int dataCenterLatency;
    private int connectedCache;
    private List<Cache> cacheList;

    public Endpoint(int endpointId, int dataCenterLatency, int connectedCache, List<Cache> cacheList) {
        this.endpointId = endpointId;
        this.dataCenterLatency = dataCenterLatency;
        this.connectedCache = connectedCache;
        this.cacheList = cacheList;
    }

    public int getEndpointId() {
        return endpointId;
    }

    public int getDataCenterLatency() {
        return dataCenterLatency;
    }

    public int getConnectedCache() {
        return connectedCache;
    }

    public List<Cache> getCacheList() {
        return cacheList;
    }
}
