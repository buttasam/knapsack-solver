package cvut.fit.file;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.util.Mapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                System.out.println("--------------");
                readAllLines(f);

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ProblemInstance> readInstanceFile(String fileName) {
        Path filePath = Paths.get("./" + this.path + "/instance/" + fileName);
        return readAllLines(filePath);
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


    public List<ProblemInstance> readAllLines(Path path) {
        try {
            Stream<String> stream = Files.lines(path);
            List<ProblemInstance> problemInstanceList = stream.map(Mapper::mapLineToProbleInstance).collect(Collectors.toList());

            return problemInstanceList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
