package processor;

import provider.EndpointProvider;
import provider.RequestsProvider;
import structure.EnterDataInfo;
import provider.DataCenter;

public class MainProcessor {

    private EnterDataInfo info;
    private DataCenter dataCenter;
    private EndpointProvider endpointProvider;
    private RequestsProvider requestsProvider;

    public MainProcessor(EnterDataInfo info, DataCenter dataCenter, EndpointProvider endpointProvider, RequestsProvider requestsProvider) {
        this.info = info;
        this.dataCenter = dataCenter;
        this.endpointProvider = endpointProvider;
        this.requestsProvider = requestsProvider;
    }


}


}
