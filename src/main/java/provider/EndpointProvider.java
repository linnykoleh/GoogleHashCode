package provider;

import structure.Endpoint;
import structure.Request;

import java.util.Comparator;
import java.util.List;

/**
 * Class for working with endpoints
 */
public class EndpointProvider {

    private List<Endpoint> endpoints;

    public EndpointProvider(List<Endpoint> endpoints) {
        this.endpoints = endpoints;
    }

    
    public int getNumberOfEndpoints() {
        return  endpoints.size();
    }
}
