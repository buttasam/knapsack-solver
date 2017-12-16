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
    private final double INIT_TEMPERATURE;
    private final double FINAL_TEMP;
    private final double COOLING_CONSTANT;
    private final int STEPS;

    public SimulatedAnnealingSolver() {
        INIT_TEMPERATURE = 1000;
        FINAL_TEMP = 10;
        COOLING_CONSTANT = 0.85;
        STEPS = 100;
    }

    public SimulatedAnnealingSolver(double INIT_TEMPERATURE, double FINAL_TEMP, double COOLING_CONSTANT, int STEPS) {
        this.INIT_TEMPERATURE = INIT_TEMPERATURE;
        this.FINAL_TEMP = FINAL_TEMP;
        this.COOLING_CONSTANT = COOLING_CONSTANT;
        this.STEPS = STEPS;
    }

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
