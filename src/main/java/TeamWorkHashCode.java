import structure.EnterDataInfo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TeamWorkHashCode {

    private static EnterDataInfo enterDataInfo;

    public static void main(String[] args) throws Exception {
        final String file = defineFileName();
        List<String> strings = Files.readAllLines(Paths.get(ClassLoader.getSystemResource(file).toURI()));
        parseParams(strings);
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
    }
}
