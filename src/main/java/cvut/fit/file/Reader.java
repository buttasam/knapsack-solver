package cvut.fit.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Samuel Butta
 */
public class Reader {

    private String path;

    public Reader(String path) {
        this.path = path;
    }

    public void readInstanceFiles() {
        try {
            Files.list(Paths.get("./" + this.path + "/instance")).sorted().forEach(f -> {
                System.out.println(f.getFileName());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readSolutionFiles() {
        try {
            Files.list(Paths.get("./" + this.path + "/solution")).sorted().forEach(f -> {
                System.out.println(f.getFileName());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
