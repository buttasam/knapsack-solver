package cvut.fit;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.ProblemSolution;
import cvut.fit.file.Reader;
import cvut.fit.logic.SolverWrapper;

import java.util.List;

/**
 * @author Samuel Butta
 */
public class App {

    public static void main(String[] args) {
        Reader reader = new Reader("data");

        String fileNumber = "32";

        List<ProblemInstance> instances = reader.readInstanceFile("knap_" + fileNumber + ".inst.dat");
        List<ProblemSolution> solutions = reader.readSolutionFile("knap_" + fileNumber + ".sol.dat");


        SolverWrapper solverWrapper = new SolverWrapper();
        solverWrapper.avgOfAvgHeuristic(instances, solutions, 100000);
    }

}
