package structure;

public class LatencyEndpoint {

    private int cacheId;
    private int latencyTime;

    public LatencyEndpoint(int cacheId, int latencyTime) {
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
