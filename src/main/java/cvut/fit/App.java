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

        // FileSolver fileSolver = new FileSolver();
        // fileSolver.solveTime("/home/samik/Documents/skola/mi-paa/knapgen/data/maxCena/", new DynamicSolver());
        // fileSolver.solveTime("/home/samik/Documents/skola/mi-paa/knapgen/data/maxVaha/", new BBSolver());
        // fileSolver.solveTime("/home/samik/Documents/skola/mi-paa/knapgen/data/kapacitaKuSumarniVaze/", new BBSolver());
        // fileSolver.solveAvg("/home/samik/Documents/skola/mi-paa/knapgen/data/maxCena/", new HeuristicSolver());
        // fileSolver.solveAvg("/home/samik/Documents/skola/mi-paa/knapgen/data/granularita/", new HeuristicSolver());


        String fileNumber = "40";
        Reader reader = new Reader("data");

        List<ProblemInstance> instances = reader.readInstanceFile("knap_" + fileNumber + ".inst.dat");
        List<ProblemSolution> solutions = reader.readSolutionFile("knap_" + fileNumber + ".sol.dat");

        SolverWrapper solverWrapper = new SolverWrapper();
        // zavislost relativni odchylky na poctu vnitrnich iteraci
/*        for(int i = 100; i <= 1000; i+=100) {
            System.out.println(i + ";" + solverWrapper.solveAllInstancesWithApproximationErrorAvg(instances, solutions, new SimulatedAnnealingSolver(500, 10, 0.85, i), 10));

        }*/

        // zavislost doby behu na poctu vnitrnich iteraci
/*        for (int i = 100; i <= 1000; i += 100) {
            System.out.println(i + ";" + solverWrapper.solveAllInstancesWithStatsAvg(instances, solutions, new SimulatedAnnealingSolver(200, 10, 0.85, i), 10));

        }*/


        // zavislost relativni odchylky na pocatecni teplote
/*        for (int i = 1000; i > 0; i -= 100) {
            System.out.println(i + ";" + solverWrapper.solveAllInstancesWithApproximationErrorAvg(instances, solutions, new SimulatedAnnealingSolver(1000, 10, 0.85, 100), 10));

        }*/


        // zavislost relativni odchylky na koeficientu ochlazování
        for(double i = 0.1; i <= 1; i +=0.05) {
            System.out.println(i + ";" + solverWrapper.solveAllInstancesWithApproximationErrorAvg(instances, solutions, new SimulatedAnnealingSolver(1000, 10, i, 100), 30));

        }

    }


}
