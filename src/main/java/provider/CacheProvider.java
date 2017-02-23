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
        this.caches = new ArrayList<>(numberOfCaches);

        for(int i=0; i < numberOfCaches; i++) {
            caches.add(new Cache(i, 0, cacheSize));
        }
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
}
