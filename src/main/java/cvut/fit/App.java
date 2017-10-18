package cvut.fit;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.ProblemSolution;
import cvut.fit.file.Reader;
import cvut.fit.logic.BruteForceSolver;
import cvut.fit.logic.HeuristicSolver;
import cvut.fit.logic.Solver;
import cvut.fit.logic.SolverWrapper;

import java.util.List;

/**
 * @author Samuel Butta
 */
public class App {

    public static void main(String[] args) {
        Reader reader = new Reader("data");
        // reader.readInstanceFiles();
        // reader.readSolutionFiles();

        List<ProblemInstance> instances = reader.readInstanceFile("knap_32.inst.dat");
        List<ProblemSolution> solutions = reader.readSolutionFile("knap_32.sol.dat");


        SolverWrapper solverWrapper = new SolverWrapper();


        //solverWrapper.solveAllInstances(instances, solutions);
        solverWrapper.solveBrutaleForceAllInstancesWithStats(instances, solutions);


/*

        ProblemInstance problemInstace = instances.get(6);
        ProblemSolution problemSolution = solutions.get(6);

        SolverWrapper solverWrapper = new SolverWrapper();
        solverWrapper.solveWithStats(problemInstace, problemSolution);
*/

    }

}
