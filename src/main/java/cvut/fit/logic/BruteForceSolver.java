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

}
