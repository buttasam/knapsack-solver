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

        String fileNumbers[] = {"25", "27", "30", "32", "35", "37", "40"};

        //String fileNumber = "20";

        for (String fileNumber: fileNumbers ) {
            List<ProblemInstance> instances = reader.readInstanceFile("knap_" + fileNumber + ".inst.dat");
            List<ProblemSolution> solutions = reader.readSolutionFile("knap_" + fileNumber + ".sol.dat");

            SolverWrapper solverWrapper = new SolverWrapper();
            solverWrapper.solveAllHeuristicWithApproximationError(instances, solutions);
        }


    }

}
