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

        if (expectedPrice != bruteForceSolution.getMaxPrice()) {
            throw new RuntimeException();
        }

        double approximationError = (double) (expectedPrice - heuristicSolution.getMaxPrice()) / expectedSolution.getMaxPrice();
        System.out.println(approximationError);

        return approximationError;
    }


    public double solveHeuristicWithApproximationError(ProblemInstance problemInstance, ProblemSolution expectedSolution) {

        int expectedPrice = expectedSolution.getMaxPrice();

        Timer heuristicTimer = new Timer(String.valueOf(problemInstance.getId()));
        ProblemSolution heuristicSolution = heuristicSolver.solve(problemInstance);
        heuristicTimer.stop();


        double approximationError = (double) (expectedPrice - heuristicSolution.getMaxPrice()) / expectedSolution.getMaxPrice();

        return approximationError;
    }


    public double solveAllInstancesWithApproximationError(List<ProblemInstance> instances, List<ProblemSolution> solutions, Solver solveType) {
        double error = 0;
        for (int i = 0; i < instances.size(); i++) {
            ProblemInstance currentInstance = instances.get(i);
            ProblemSolution currentSolution = solutions.get(i);

            error += solveWithApproximationError(currentInstance, currentSolution, solveType);
        }

        return error / instances.size();
    }

    public double solveAllInstancesWithApproximationErrorAvg(List<ProblemInstance> instances, List<ProblemSolution> solutions, Solver solveType, int n) {
        double avg = 0;
        for (int i = 0; i < n; i++) {
            avg +=  solveAllInstancesWithApproximationError(instances, solutions, solveType);
        }

        double result = (avg / n);

        return result;
    }





    public double solveWithApproximationError(ProblemInstance problemInstance, ProblemSolution expectedSolution, Solver solver) {
        int expectedPrice = expectedSolution.getMaxPrice();

        ProblemSolution solution = solver.solve(problemInstance);

        double approximationError = (double) (expectedPrice - solution.getMaxPrice()) / expectedSolution.getMaxPrice();

        return approximationError;
    }

    public double solveAllHeuristicWithApproximationError(List<ProblemInstance> instances, List<ProblemSolution> solutions) {
        double avgSum = 0;
        double max = 0;

        for(int i = 0; i < instances.size(); i++) {
            double result = solveHeuristicWithApproximationError(instances.get(i), solutions.get(i));

            if(max < result) {
                max = result;
            }

            avgSum += result;
        }

        double avg = avgSum / instances.size();

        System.out.println((avg * 100) + " \\% & " + (max * 100) + " \\%");

        return avg;
    }


    public void solveAllInstances(List<ProblemInstance> instances, List<ProblemSolution> solutions) {
        double sum = 0;

        for (int i = 0; i < instances.size(); i++) {
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
        for (int i = 0; i < instances.size(); i++) {
            ProblemInstance currentInstance = instances.get(i);
            Timer timer = new Timer("id: " + currentInstance.getId());
            ProblemSolution currentSolution = bruteForceSolver.solveIterative(instances.get(i));
            time += timer.stop();

            if (solutions.get(i).getMaxPrice() != currentSolution.getMaxPrice()) {
                throw new RuntimeException();
            }
        }

        double timeAvg = time / instances.size();
        System.out.println("brutale force time avg: " + timeAvg);

        return timeAvg;
    }

    public double solveHeuristicAllInstancesWithStats(List<ProblemInstance> instances, List<ProblemSolution> solutions) {
        double time = 0;
        for (int i = 0; i < instances.size(); i++) {
            ProblemInstance currentInstance = instances.get(i);
            Timer timer = new Timer("id: " + currentInstance.getId());
            ProblemSolution currentSolution = heuristicSolver.solve(instances.get(i));
            time += timer.stop();
        }

        double timeAvg = time / instances.size();
        System.out.println("heuristic force time avg: " + timeAvg);

        return timeAvg;
    }



    public double solveAllInstancesWithStats(List<ProblemInstance> instances, List<ProblemSolution> solutions, Solver solveType) {
        double time = 0;
        for (int i = 0; i < instances.size(); i++) {
            ProblemInstance currentInstance = instances.get(i);
            Timer timer = new Timer("id: " + currentInstance.getId());
            ProblemSolution currentSolution = solveType.solve(instances.get(i));

            time += timer.stop();
        }

        double timeAvg = time / instances.size();

        return timeAvg;
    }


    public double solveAllInstancesWithMaxApproximationError(List<ProblemInstance> instances, List<ProblemSolution> solutions, Solver solveType) {
        double maxError = 0;
        for (int i = 0; i < instances.size(); i++) {
            ProblemInstance currentInstance = instances.get(i);

            ProblemSolution currentSolution;
            if(solutions == null) {
                DynamicSolver dynamicSolver = new DynamicSolver();
                currentSolution = dynamicSolver.solve(currentInstance);
            } else {
                currentSolution = solutions.get(i);
            }
            double approximationError = solveWithApproximationError(currentInstance, currentSolution, solveType);

            maxError = Math.max(maxError, approximationError);
        }

        return maxError;
    }


    public double solveAllInstancesWithStatsAvg(List<ProblemInstance> instances, List<ProblemSolution> solutions, Solver solveType , int n) {
        double avg = 0;
        for (int i = 0; i < n; i++) {
            avg +=  solveAllInstancesWithStats(instances, solutions, solveType);
        }

        double result = (avg / n);

        return result;
    }


    public double avgOfAvgHeuristic(List<ProblemInstance> instances, List<ProblemSolution> solutions, int n) {
        double avg = 0;
        for (int i = 0; i < n; i++) {
            avg += solveHeuristicAllInstancesWithStats(instances, solutions);
        }

        double result = (avg / n);

        System.out.println("brutal force avg of " + n + " : " + result);

        return result;
    }


}
