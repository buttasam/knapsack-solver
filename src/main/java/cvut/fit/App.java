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

        List<ProblemInstance> instances = reader.readInstanceFile("knap_04.inst.dat");
        List<ProblemSolution> solutions = reader.readSolutionFile("knap_04.sol.dat");


        Solver solver = new BruteForceSolver();

        for(int i = 0; i < instances.size(); i++) {
            ProblemInstance problemInstace = instances.get(i);
            ProblemSolution problemSolution = solutions.get(i);

            SolverWrapper solverWrapper = new SolverWrapper();
            solverWrapper.solveWithStats(problemInstace, problemSolution);
        }

/*

        ProblemInstance problemInstace = instances.get(6);
        ProblemSolution problemSolution = solutions.get(6);

        SolverWrapper solverWrapper = new SolverWrapper();
        solverWrapper.solveWithStats(problemInstace, problemSolution);
*/



    }

}
