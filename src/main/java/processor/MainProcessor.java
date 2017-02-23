package processor;

import provider.EndpointProvider;
import provider.RequestsProvider;
import provider.VideoProvider;
import structure.EnterDataInfo;

public class MainProcessor {

    private EnterDataInfo info;
    private VideoProvider videoProvider;
    private static EndpointProvider endpointProvider;
    private RequestsProvider requestsProvider;

    public MainProcessor(EnterDataInfo info, VideoProvider videoProvider, EndpointProvider endpointProvider, RequestsProvider requestsProvider) {
        this.info = info;
        this.videoProvider = videoProvider;
        MainProcessor.endpointProvider = endpointProvider;
        this.requestsProvider = requestsProvider;
    }


}

