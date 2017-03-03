package structure;

import java.util.List;

public class Endpoint {

    private int endpointId;
    private int dataCenterLatency;
    private int connectedCache;
    private List<CacheInfo> cacheInfoList;

    public Endpoint(int endpointId, int dataCenterLatency, int connectedCache, List<CacheInfo> cacheInfoList) {
        this.endpointId = endpointId;
        this.dataCenterLatency = dataCenterLatency;
        this.connectedCache = connectedCache;
        this.cacheInfoList = cacheInfoList;
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

    public List<CacheInfo> getCacheInfoList() {
        return cacheInfoList;
    }
}
