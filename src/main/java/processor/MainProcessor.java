package processor;

import provider.CacheProvider;
import provider.EndpointProvider;
import provider.RequestsProvider;
import structure.CacheInfo;
import structure.CacheState;
import structure.Endpoint;
import structure.EnterDataInfo;
import provider.DataCenter;
import structure.Request;
import structure.Video;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MainProcessor {

    private EnterDataInfo info;
    private DataCenter dataCenter;
    private EndpointProvider endpointProvider;
    private RequestsProvider requestsProvider;
    private CacheProvider cacheProvider;

    private Set<Video> notCachedVideo = new HashSet<>();

    public MainProcessor(EnterDataInfo info, DataCenter dataCenter, EndpointProvider endpointProvider, RequestsProvider requestsProvider, CacheProvider cacheProvider) {
        this.info = info;
        this.dataCenter = dataCenter;
        this.endpointProvider = endpointProvider;
        this.requestsProvider = requestsProvider;
        this.cacheProvider = cacheProvider;
    }

    public Set<CacheState> doIt(){
        final List<Request> allRequestsSortedByNumber = requestsProvider.getBestRequests();

        for(Request request : allRequestsSortedByNumber){
            final Endpoint endpoint = endpointProvider.getEndpointById(request.getEndpointId());

            final List<CacheInfo> cacheInfoList = endpoint.getCacheInfoList();
            final Video video = dataCenter.getVideoById(request.getVideoId());

            final boolean isVideoWasAddedToCache = cacheProvider.addVideoToCache(video, cacheInfoList);
            if(!isVideoWasAddedToCache){
                notCachedVideo.add(video);
            }
        }

        for (Video video : notCachedVideo){
            final boolean isVideoWasAddedToCache = cacheProvider.addNotCachedVideoToCache(video);
            if(!isVideoWasAddedToCache){
                System.out.println("Not added to cache : " + video);
            }
        }

        return cacheProvider.getCaches().stream().filter(cache -> cache.getAvailableSize() != cache.getSize()).collect(Collectors.toSet());
    }

}

