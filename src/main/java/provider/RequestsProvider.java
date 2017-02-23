package provider;

import structure.Request;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class for working with requests
 */
public class RequestsProvider {

    private List<Request> requests;

    public RequestsProvider(List<Request> requests) {
        this.requests = requests;
        Collections.sort(requests, Comparator.comparingInt(Request::getRequestsNumber));
    }

    public void findSomethind(){

    }

}
