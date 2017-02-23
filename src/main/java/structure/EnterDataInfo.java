package structure;


public class EnterDataInfo {

    private int videos;
    private int endpoints;
    private int requestDescriptions;
    private int caches;
    private int sizeEachCache;

    public EnterDataInfo(int videos, int endpoints, int requestDescriptions, int caches, int sizeEachCache) {
        this.videos = videos;
        this.endpoints = endpoints;
        this.requestDescriptions = requestDescriptions;
        this.caches = caches;
        this.sizeEachCache = sizeEachCache;
    }

    public int getVideos() {
        return videos;
    }

    public int getEndpoints() {
        return endpoints;
    }

    public int getRequestDescriptions() {
        return requestDescriptions;
    }

    public int getCaches() {
        return caches;
    }

    public int getSizeEachCache() {
        return sizeEachCache;
    }
}
