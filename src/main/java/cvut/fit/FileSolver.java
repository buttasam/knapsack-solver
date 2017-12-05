package cvut.fit;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.file.Reader;
import cvut.fit.logic.DynamicSolver;
import cvut.fit.logic.Solver;
import cvut.fit.logic.SolverWrapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

/**
 * @author Samuel Butta
 */
public class FileSolver {

    public void solveTime(String filePath, Solver solver) {
        System.out.println(";");
        SolverWrapper solverWrapper = new SolverWrapper();
        try {
            Files.list(Paths.get(filePath))
                    .filter(f -> !f.getFileName().toString().equals("script.sh"))
                    .sorted(Comparator.comparingDouble(o -> Double.parseDouble(o.getFileName().toString()))).
                    forEach(f -> {
                        String fileName = f.getFileName().toString();
                                // read instances for file
                                List<ProblemInstance> instances = Reader.mapInstance(f);
                                double result = solverWrapper.solveAllInstancesWithStatsAvg(instances, null, solver, 1);

                                System.out.println(f.getFileName() + ";" + result);
                            }
                    );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void solveAvg(String filePath, Solver solver) {
        System.out.println(";");
        SolverWrapper solverWrapper = new SolverWrapper();
        try {
            Files.list(Paths.get(filePath))
                    .filter(f -> !f.getFileName().toString().equals("script.sh"))
                    .sorted(Comparator.comparingDouble(o -> Double.parseDouble(o.getFileName().toString()))).
                    forEach(f -> {
                                String fileName = f.getFileName().toString();
                                // read instances for file
                                List<ProblemInstance> instances = Reader.mapInstance(f);
                                double result = solverWrapper.solveAllInstancesWithMaxApproximationError(instances, null, solver);

                                System.out.println(f.getFileName() + ";" + result);
                            }
                    );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
