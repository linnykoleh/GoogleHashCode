package structure;

public class LatencyOfEndpoint {

    private int cacheId;
    private int latencyTime;

    public LatencyOfEndpoint(int cacheId, int latencyTime) {
        this.cacheId = cacheId;
        this.latencyTime = latencyTime;
    }

    public int getCacheId() {
        return cacheId;
    }

    public int getLatencyTime() {
        return latencyTime;
    }
}
