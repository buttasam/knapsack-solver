package cvut.fit.logic;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.ProblemSolution;
import cvut.fit.entity.Thing;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Samuel Butta
 */
public class FtpasSolver implements Solver {

    private DynamicSolver dynamicSolver = new DynamicSolver();

    private double k;
    private double e;

    public FtpasSolver(double e) {
        this.e = e;
    }

    @Override
    public ProblemSolution solve(ProblemInstance problemInstance) {

        // nejvyssi cena v instanci
        int maxPrice = problemInstance.maxPrice();

        k = ((e * maxPrice) / problemInstance.getThings().size());

        List<Thing> originalThings = problemInstance.getThings();

        // vsechny ceny v instanci vydelit k
        List<Thing> modifiedThings = problemInstance.getThings().stream().map(t -> new Thing(t.getWeight(), (int)(t.getPrice() / k))).collect(Collectors.toList());

        // vyresit dynamic solverem
        problemInstance.setThings(modifiedThings);
        ProblemSolution solution = dynamicSolver.solve(problemInstance);

        // secist puvodi ceny
        problemInstance.setThings(originalThings);
        problemInstance.setOption(solution.getOption());
        System.out.println(problemInstance.getPriceForOption());

        return null;
    }

}
