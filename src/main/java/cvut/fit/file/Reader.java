package cvut.fit.file;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.ProblemSolution;
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
                //mapInstance(f);

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ProblemInstance> readInstanceFile(String fileName) {
        Path filePath = Paths.get("./" + this.path + "/instance/" + fileName);
        return mapInstance(filePath);
    }

    public List<ProblemSolution> readSolutionFile(String fileName) {
        Path filePath = Paths.get("./" + this.path + "/solution/" + fileName);
        return mapSolution(filePath);
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


    public List<ProblemInstance> mapInstance(Path path) {
        try {
            Stream<String> stream = Files.lines(path);
            List<ProblemInstance> problemInstanceList = stream.map(Mapper::mapLineToProbleInstance).collect(Collectors.toList());

            return problemInstanceList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ProblemSolution> mapSolution(Path path) {
        try {
            Stream<String> stream = Files.lines(path);
            List<ProblemSolution> problemInstanceList = stream.map(Mapper::mapLineToProblemSolution).collect(Collectors.toList());

            return problemInstanceList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
