import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TeamWorkHashCode {

    public static void main(String[] args) throws Exception {

        List<String> strings = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("filename").toURI()));
    }
}
