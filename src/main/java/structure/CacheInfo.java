package structure;

public class CacheInfo {

    private int cacheId;
    private int latencyTime;
    private int size;

    public CacheInfo(int cacheId, int latencyTime, int size) {
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

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CacheInfo cacheInfo = (CacheInfo) o;

        if (cacheId != cacheInfo.cacheId) {
            return false;
        }
        if (latencyTime != cacheInfo.latencyTime) {
            return false;
        }
        return size == cacheInfo.size;
    }

    @Override
    public int hashCode() {
        int result = cacheId;
        result = 31 * result + latencyTime;
        result = 31 * result + size;
        return result;
    }
}
