import structure.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamWorkHashCode {

    private static EnterDataInfo enterDataInfo;

    private static List<Video> videos;
    private static List<Endpoint> endpoints;
    private static List<Request> requests;

    public static void main(String[] args) throws Exception {
        final String file = defineFileName();
        List<String> strings = Files.readAllLines(Paths.get(ClassLoader.getSystemResource(file).toURI()));
        parseParams(strings);

        System.out.println("Victory");
    }

    private static String defineFileName() {
        System.out.println("Which file you want to parse? (k, m, t, v)");
        final Scanner scan = new Scanner(System.in);
        final String fileName = scan.next();

        switch(fileName) {
            case "k":
                return "kittens.in";
            case "m":
                return "me_at_the_zoo.in";
            case "t":
                return "trending_today.in";
            case "v":
                return "videos_worth_spreading.in";
            default:
                throw new IllegalArgumentException("something goes wrong");
        }
    }

    private static void parseParams(List<String> strings){
        String entryPoint = strings.get(0);

        String[] entryParams = entryPoint.split(" ");
        enterDataInfo = new EnterDataInfo(
                Integer.parseInt(entryParams[0]),
                Integer.parseInt(entryParams[1]),
                Integer.parseInt(entryParams[2]),
                Integer.parseInt(entryParams[3]),
                Integer.parseInt(entryParams[4]));

        String[] videosStrings = strings.get(1).split(" ");
        videos = new ArrayList<>(enterDataInfo.getVideos());

        for(int i = 0; i < videosStrings.length; i++ ) {
            videos.add(new Video(i, Integer.parseInt(videosStrings[i])));
        }

        requests = parseRequests(strings);
        endpoints = parseEndPoints(strings.subList(2,strings.size() - enterDataInfo.getRequestDescriptions()));

    }

    private static List<Endpoint> parseEndPoints(List<String> strings) {

        ArrayList<Endpoint> endpoints = new ArrayList<>(enterDataInfo.getEndpoints());
        for(int i = 0; i < strings.size(); ) {
            String[] endpointParams = strings.get(i).split(" ");

            int dataCenterLatency = Integer.parseInt(endpointParams[0]);
            int cachesCount = Integer.parseInt(endpointParams[1]);

            if (cachesCount > 0) {

                List<Cache> latencies = new ArrayList<>(cachesCount);

                for(int j = 0; j < cachesCount; j++) {
                    String[] latencyParams = strings.get(i + 1 + j).split(" ");
                    latencies.add(new Cache(Integer.parseInt(latencyParams[0]),
                            Integer.parseInt(latencyParams[1])));
                }

                i = i + 1 + cachesCount;

                endpoints.add(new Endpoint(dataCenterLatency, cachesCount, latencies));

            } else {
                endpoints.add(new Endpoint(dataCenterLatency, cachesCount, null));
            }
        }
        return endpoints;
    }

    private static List<Request> parseRequests(List<String> strings) {
        List<String> requestsStrings =
                strings.subList(strings.size() - enterDataInfo.getRequestDescriptions(), strings.size());

        List<Request> requests = new ArrayList<>();

        requestsStrings.forEach(requestString -> {
            String[] requestStringParams = requestString.split(" ");
            requests.add(new Request(Integer.parseInt(requestStringParams[0]),
                    Integer.parseInt(requestStringParams[1]),
                    Integer.parseInt(requestStringParams[2])));
        });

        return requests;
    }
}
