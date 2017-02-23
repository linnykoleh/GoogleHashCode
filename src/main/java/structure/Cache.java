package structure;

public class Cache {

    private int cacheId;
    private int latencyTime;

    public Cache(int cacheId, int latencyTime) {
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
