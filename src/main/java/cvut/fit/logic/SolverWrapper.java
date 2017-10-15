package cvut.fit.logic;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.ProblemSolution;
import cvut.fit.util.Timer;

/**
 * @author Samuel Butta
 */
public class SolverWrapper {


    private Solver bruteForceSolver = new BruteForceSolver();
    private Solver heuristicSolver = new HeuristicSolver();


    public void solveWithStats(ProblemInstance problemInstance, ProblemSolution expectedSolution) {

        int expectedPrice = expectedSolution.getMaxPrice();

        Timer bruteForceTimer = new Timer(String.valueOf(problemInstance.getId()));
        ProblemSolution bruteForceSolution = bruteForceSolver.solve(problemInstance);
        bruteForceTimer.stop();

        Timer heuristicTimer = new Timer(String.valueOf(problemInstance.getId()));
        ProblemSolution heuristicSolution = heuristicSolver.solve(problemInstance);
        heuristicTimer.stop();

        if(expectedPrice != bruteForceSolution.getMaxPrice()) {
            throw new RuntimeException();
        }

        double approximationError = (double) (expectedPrice - heuristicSolution.getMaxPrice()) / expectedSolution.getMaxPrice();
        System.out.println(approximationError);
    }

}
