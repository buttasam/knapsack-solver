package cvut.fit.logic;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.ProblemSolution;

/**
 * @author Samuel Butta
 */
public class SimulatedAnnealingSolver implements Solver {

    /**
     * Params
     */
    private static final double INIT_TEMPERATURE = 1000;
    private static final double FINAL_TEMP = 10;
    private static final double COOLING_CONSTANT = 0.85;
    private static final int STEPS = 100;

    @Override
    public ProblemSolution solve(ProblemInstance problemInstance) {
        // init solution
        problemInstance.setRandomValidOption();
        int bestPrice = problemInstance.getPriceForOption();

        double temperature = INIT_TEMPERATURE;

        while (!frozen(temperature)) {

            for (int i = 0; i < STEPS; i++) {
                // find new state
                problemInstance.setRandomValidOption();

                // compare new state
                bestPrice = findBestSolution(bestPrice, problemInstance);
            }
            temperature *= COOLING_CONSTANT;
        }

        ProblemSolution solution = new ProblemSolution();
        solution.setMaxPrice(bestPrice);

        return solution;
    }


    public int findBestSolution(int bestPrice, ProblemInstance problemInstance) {
        if (bestPrice < problemInstance.getPriceForOption()) {
            return problemInstance.getPriceForOption();
        } else {
            return bestPrice;
        }
    }

    public boolean frozen(double temperature) {
        return (temperature < FINAL_TEMP);
    }

}
