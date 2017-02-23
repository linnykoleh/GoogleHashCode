package provider;

import structure.Cache;
import structure.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 23.02.17.
 */
public class CacheProvider {
    List<Cache> caches;

    public CacheProvider(int numberOfCaches, int cacheSize) {
        this.caches = new ArrayList<>();
    }

    private boolean canBeAddedToCache(int videoSize, int cacheId) {
        return caches.stream()
                .filter(cache -> cache.getCacheId() == cacheId)
                .anyMatch(cache -> cache.getAvelibleSize() >= videoSize);
    }

    public void addVideoToCache(Video video, int cacheId) {
        if(canBeAddedToCache(video.getSize(), cacheId)) {
            caches.stream()
                    .filter(cache -> cache.getCacheId() == cacheId)
                    .forEach(cache -> cache.addVideo(video));
        }
    }

    public void findVideoToBestCache(List<Cache> caches, Video video) {

        int bestCacheIndex = 0;
        int latencyTime = caches.get(0).getLatencyTime();

        for(int i = 0; i < caches.size(); i++) {
            if (caches.get(i).getLatencyTime() < latencyTime){
                latencyTime = caches.get(i).getLatencyTime();
            }
        }

        for(int i = 0; i < caches.size(); i++) {
            if (caches.get(i).getLatencyTime() == latencyTime){
                bestCacheIndex = i;
            }
        }

        this.caches.add(caches.get(bestCacheIndex));
    }
}
