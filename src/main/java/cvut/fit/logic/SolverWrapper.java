package cvut.fit.logic;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.ProblemSolution;
import cvut.fit.util.Timer;

import java.util.List;

/**
 * @author Samuel Butta
 */
public class SolverWrapper {


    private BruteForceSolver bruteForceSolver = new BruteForceSolver();
    private Solver heuristicSolver = new HeuristicSolver();


    public double solveWithStats(ProblemInstance problemInstance, ProblemSolution expectedSolution) {

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

        return approximationError;
    }


    public void solveAllInstances(List<ProblemInstance> instances, List<ProblemSolution> solutions) {
        double sum = 0;

        for(int i = 0; i < instances.size(); i++) {
            ProblemInstance problemInstance = instances.get(i);
            ProblemSolution problemSolution = solutions.get(i);

            SolverWrapper solverWrapper = new SolverWrapper();
            double approximationError = solverWrapper.solveWithStats(problemInstance, problemSolution);

            sum += approximationError;

        }

        System.out.println("avg: " + (sum / instances.size()));
    }


    public double solveBrutaleForceAllInstancesWithStats(List<ProblemInstance> instances, List<ProblemSolution> solutions) {

        double time = 0;
        for(int i = 0; i < instances.size(); i++) {
            ProblemInstance currentInstance = instances.get(i);
            Timer timer = new Timer("id: " + currentInstance.getId());
            ProblemSolution currentSolution = bruteForceSolver.solveIterative(instances.get(i));
            time += timer.stop();

            if(solutions.get(i).getMaxPrice() != currentSolution.getMaxPrice()) {
                throw new RuntimeException();
            }
        }

        double timeAvg = time / instances.size();
        System.out.println("brutale force time avg: " + timeAvg);

        return timeAvg;
    }

    public double solveHeuristicAllInstancesWithStats(List<ProblemInstance> instances, List<ProblemSolution> solutions) {
        double time = 0;
        for(int i = 0; i < instances.size(); i++) {
            ProblemInstance currentInstance = instances.get(i);
            Timer timer = new Timer("id: " + currentInstance.getId());
            ProblemSolution currentSolution = heuristicSolver.solve(instances.get(i));
            time += timer.stop();
        }

        double timeAvg = time / instances.size();
        System.out.println("heuristic force time avg: " + timeAvg);

        return timeAvg;
    }




}
