package cvut.fit.logic;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.ProblemSolution;

/**
 * @author Samuel Butta
 */
public interface Solver {

    public ProblemSolution solve(ProblemInstance problemInstance);

}
