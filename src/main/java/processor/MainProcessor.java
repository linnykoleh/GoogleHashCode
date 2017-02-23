package processor;

import provider.EndpointProvider;
import provider.RequestsProvider;
import structure.EnterDataInfo;
import provider.VideoProvider;

public class MainProcessor {

    private EnterDataInfo info;
    private VideoProvider videoProvider;
    private EndpointProvider endpointProvider;
    private RequestsProvider requestsProvider;

    public MainProcessor(EnterDataInfo info, VideoProvider videoProvider, EndpointProvider endpointProvider, RequestsProvider requestsProvider) {
        this.info = info;
        this.videoProvider = videoProvider;
        this.endpointProvider = endpointProvider;
        this.requestsProvider = requestsProvider;
    }


}
