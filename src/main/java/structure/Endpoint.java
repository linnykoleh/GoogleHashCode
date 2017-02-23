package structure;

import java.util.List;

public class Endpoint {

    private int dataCenterLatency;
    private int connectedCache;
    private List<Cache> cacheList;

    public Endpoint(int dataCenterLatency, int connectedCache, List<Cache> cacheList) {
        this.dataCenterLatency = dataCenterLatency;
        this.connectedCache = connectedCache;
        this.cacheList = cacheList;
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
