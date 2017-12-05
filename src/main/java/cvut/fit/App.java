package cvut.fit;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.ProblemSolution;
import cvut.fit.file.Reader;
import cvut.fit.logic.*;

import java.util.List;

/**
 * @author Samuel Butta
 */
public class App {

    public static void main(String[] args) {
/*
        Reader reader = new Reader("data");

        String fileNumbers[] = {"04", "10", "15","20","22","25","27","30", "32","35","37","40",};
        //String fileNumber = "20";

        for (String fileNumber: fileNumbers ) {
            List<ProblemInstance> instances = reader.readInstanceFile("knap_" + fileNumber + ".inst.dat");
            List<ProblemSolution> solutions = reader.readSolutionFile("knap_" + fileNumber + ".sol.dat");

            SolverWrapper solverWrapper = new SolverWrapper();
            // System.out.println(fileNumber + " - " + solverWrapper.solveAllInstancesWithStatsAvg(instances, solutions, new DynamicSolver(), 1));
            System.out.println(solverWrapper.solveAllInstancesWithMaxApproximationError(instances, solutions, new FtpasSolver(0.5)));
            // System.out.println(fileNumber);
            // System.out.println(solverWrapper.solveAllInstancesWithStatsAvg(instances, solutions, new FtpasSolver(0.5), 100));
        }
*/

    FileSolver fileSolver = new FileSolver();
    // fileSolver.solveTime("/home/samik/Documents/skola/mi-paa/knapgen/data/maxCena/", new DynamicSolver());
    // fileSolver.solveTime("/home/samik/Documents/skola/mi-paa/knapgen/data/maxVaha/", new BBSolver());
    // fileSolver.solveTime("/home/samik/Documents/skola/mi-paa/knapgen/data/kapacitaKuSumarniVaze/", new BBSolver());
    // fileSolver.solveAvg("/home/samik/Documents/skola/mi-paa/knapgen/data/maxCena/", new HeuristicSolver());
     fileSolver.solveAvg("/home/samik/Documents/skola/mi-paa/knapgen/data/granularita/", new HeuristicSolver());


    }

}
