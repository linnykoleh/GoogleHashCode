package structure;

public class Cache {

    private int cacheId;
    private int latencyTime;
    private int size;

    public Cache(int cacheId, int latencyTime, int size) {
        this.cacheId = cacheId;
        this.latencyTime = latencyTime;
        this.size = size;
    }

    public int getCacheId() {
        return cacheId;
    }

    public int getLatencyTime() {
        return latencyTime;
    }

    public int getAvelibleSize() {
        return size;
    }
}
