package processor;

import provider.EndpointProvider;
import provider.RequestsProvider;
import structure.Endpoint;
import structure.EnterDataInfo;
import provider.DataCenter;
import structure.Request;

import java.util.List;

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

    public void doIt(){
        final List<Request> allRequestsSortedByNumber = requestsProvider.getAllRequests();
        final List<Endpoint> bestEndpoint = endpointProvider.getBestEndpoint();

        for(Request request : allRequestsSortedByNumber){
            for()
        }
    }


}
