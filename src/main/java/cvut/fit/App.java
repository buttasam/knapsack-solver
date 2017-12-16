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
        String fileNumber = "40";
        Reader reader = new Reader("data");

        List<ProblemInstance> instances = reader.readInstanceFile("knap_" + fileNumber + ".inst.dat");
        List<ProblemSolution> solutions = reader.readSolutionFile("knap_" + fileNumber + ".sol.dat");

        SolverWrapper solverWrapper = new SolverWrapper();
        // zavislost relativni odchylky na poctu vnitrnich iteraci
        for(int i = 100; i <= 1000; i+=100) {
            System.out.println(i + ";" + solverWrapper.solveAllInstancesWithApproximationErrorAvg(instances, solutions, new SimulatedAnnealingSolver(500, 10, 0.85, i), 10));

        }

        // zavislost doby behu na poctu vnitrnich iteraci
        for (int i = 100; i <= 1000; i += 100) {
            System.out.println(i + ";" + solverWrapper.solveAllInstancesWithStatsAvg(instances, solutions, new SimulatedAnnealingSolver(200, 10, 0.85, i), 10));

        }


        // zavislost relativni odchylky na pocatecni teplote
        for (int i = 1000; i > 0; i -= 100) {
            System.out.println(i + ";" + solverWrapper.solveAllInstancesWithApproximationErrorAvg(instances, solutions, new SimulatedAnnealingSolver(1000, 10, 0.85, 100), 10));

        }

        // zavislost relativni odchylky na koeficientu ochlazování
        for(double i = 0.1; i <= 1; i +=0.05) {
            System.out.println(i + ";" + solverWrapper.solveAllInstancesWithApproximationErrorAvg(instances, solutions, new SimulatedAnnealingSolver(1000, 10, i, 100), 30));

        }

    }


}
