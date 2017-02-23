package structure;

public class Request {

    private int videoId;
    private int endpointId;
    private int requestsNumber;

    public Request(int videoId, int endpointId, int requestsNumber) {
        this.videoId = videoId;
        this.endpointId = endpointId;
        this.requestsNumber = requestsNumber;
    }

    public int getVideoId() {
        return videoId;
    }

    public int getEndpointId() {
        return endpointId;
    }

    public int getRequestsNumber() {
        return requestsNumber;
    }
}
