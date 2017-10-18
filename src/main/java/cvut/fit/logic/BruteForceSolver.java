package cvut.fit.logic;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.ProblemResult;
import cvut.fit.entity.ProblemSolution;
import cvut.fit.entity.Thing;
import cvut.fit.util.SetUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Samuel Butta
 */
public class BruteForceSolver implements Solver {


    @Override
    public ProblemSolution solve(ProblemInstance problemInstance) {

        ProblemSolution problemSolution = new ProblemSolution();
        problemInstance.setId(problemInstance.getId());

        Set<Set<Thing>> powerSet = SetUtil.powerSet(problemInstance.getThings());

        //System.out.println("-----------subsets-generated-----------");

        List<ProblemResult> results = powerSet.stream().map(this::mapSubsetToResult).collect(Collectors.toList());
        ProblemResult maxResult = results.stream()
                .filter(r -> r.getCount() <= problemInstance.getCount())
                .filter(r -> r.getWeight() <= problemInstance.getCapacity())
                .max(Comparator.comparing(ProblemResult::getPrice))
                .get();

        problemSolution.setCount(maxResult.getCount());
        problemSolution.setMaxPrice(maxResult.getPrice());

        return problemSolution;
    }


    public ProblemResult mapSubsetToResult(Set<Thing> subset) {
        int count = subset.size();
        int price = subset.stream().mapToInt(f -> f.getPrice()).sum();
        int weight = subset.stream().mapToInt(f -> f.getWeight()).sum();

        return new ProblemResult(count, price, weight);
    }


    /**
     * http://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
     */
    public ProblemSolution solveIterative(ProblemInstance problemInstance) {
        int maxPrice = 0;
        int finalCount = 0;

        List<Thing> things = problemInstance.getThings();

        for (long i = 0; i < ((long)1 << things.size()); i++) {

            int sumPrice = 0;
            int sumWeight = 0;
            int count = 0;

            for (int j = 0; j < things.size(); j++) {
                if ((i & ((long) 1 << j)) > 0) {
                    count++;
                    sumPrice += things.get(j).getPrice();
                    sumWeight += things.get(j).getWeight();
                }
            }

            if (sumPrice > maxPrice && sumWeight <= problemInstance.getCapacity()) {
                maxPrice = sumPrice;
                finalCount = count;
            }
        }

        ProblemSolution solution = new ProblemSolution();
        solution.setId(problemInstance.getId());
        solution.setCount(finalCount);
        solution.setMaxPrice(maxPrice);

        return solution;
    }
}
