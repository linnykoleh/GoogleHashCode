package provider;

import structure.CacheInfo;
import structure.CacheState;
import structure.Video;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by stas on 23.02.17.
 */
public class CacheProvider {

    private Set<CacheState> caches;

    public CacheProvider(Set<CacheState> cacheStates) {
        this.caches = cacheStates;
    }

    public boolean addVideoToCache(Video video, List<CacheInfo> cachesInfo) {

       int videoSize = video.getSize();

		boolean isAlreadyCached = caches.stream()
				.filter(cache -> cachesInfo.stream().anyMatch(cacheInfo -> cache.getCacheId() == cacheInfo.getCacheId()))
				.anyMatch(cache -> cache.getVideos().stream().anyMatch(videoFromCache -> videoFromCache.getId() == video.getId()));

		if (isAlreadyCached) {
			return false;
		}

        final List<CacheState> cacheStatesBeforeLatencyCheck = caches.stream()
                .filter(cache -> cachesInfo.stream().anyMatch(cacheInfo -> cache.getCacheId() == cacheInfo.getCacheId()))
                .filter(cache -> cache.getAvailableSize() >= videoSize).collect(Collectors.toList());



        Optional <CacheInfo> cacheInfoWithMinimumLatency = cachesInfo.stream()
                .filter(cacheInfo -> cacheStatesBeforeLatencyCheck.stream().anyMatch(cacheState -> cacheState.getCacheId() == cacheInfo.getCacheId()))
                .min(Comparator.comparingInt(CacheInfo::getLatencyTime)); // read about if equals

        if(cacheInfoWithMinimumLatency.isPresent()) {

            Optional<CacheState> bestCache = cacheStatesBeforeLatencyCheck.stream()
                    .filter(cache -> cache.getCacheId() == cacheInfoWithMinimumLatency.get().getCacheId())
                    .findFirst();

            if(bestCache.isPresent()){
                final CacheState cache = bestCache.get();
                cache.addVideo(video);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean addNotCachedVideoToCache(Video video) {

        int videoSize = video.getSize();

        final Optional<CacheState> cacheState = caches.stream()
                .filter(cache -> cache.getAvailableSize() >= videoSize).findFirst();

        if(cacheState.isPresent()){
            final CacheState cache= cacheState.get();
            cache.addVideo(video);
            return true;
        }
        return false;
    }

    public Set<CacheState> getCaches() {
        return caches;
    }
}
