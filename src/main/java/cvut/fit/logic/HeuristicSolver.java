package cvut.fit.logic;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.ProblemSolution;
import cvut.fit.entity.Thing;

/**
 * @author Samuel Butta
 */
public class HeuristicSolver implements Solver {

    @Override
    public ProblemSolution solve(ProblemInstance problemInstance) {
        problemInstance.getThings().sort((t1, t2) -> {
            double p1 = ((double)t1.getPrice() / t1.getWeight());
            double p2 = ((double)t2.getPrice() / t2.getWeight());
            if (p1 < p2) {
                return 1;
            }
            if (p1 > p2) {
                return -1;
            } else {
                return 0;
            }
        });

        int maxPrice = 0;
        int weight = 0;
        for (Thing thing : problemInstance.getThings()) {

            int newWight = weight + thing.getWeight();

            if (newWight <= problemInstance.getCapacity()) {
                maxPrice += thing.getPrice();
                weight += thing.getWeight();
            } else {
                break;
            }

        }

        ProblemSolution solution = new ProblemSolution();
        solution.setMaxPrice(maxPrice);

        return solution;
    }

}
