package cvut.fit;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.ProblemSolution;
import cvut.fit.entity.Thing;
import cvut.fit.logic.BruteForceSolver;
import cvut.fit.logic.Solver;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by samik on 12.10.17.
 */
public class SolverTest {



    @Test
    public void basicTest() {
        ProblemInstance problemInstance = new ProblemInstance();
        problemInstance.setId(9000);
        problemInstance.setCount(4);
        problemInstance.setCount(100);


        problemInstance.addThing(new Thing(18, 114));
        problemInstance.addThing(new Thing(42, 136));
        problemInstance.addThing(new Thing(88, 192));
        problemInstance.addThing(new Thing(3, 223));


        ProblemSolution expectedSolution = new ProblemSolution();
        expectedSolution.setId(9000);
        expectedSolution.setCount(4);
        expectedSolution.setMaxPrice(473);
        expectedSolution.addResult(true);
        expectedSolution.addResult(true);
        expectedSolution.addResult(false);
        expectedSolution.addResult(true);

        Solver solver = new BruteForceSolver();
        ProblemSolution result = solver.solve(problemInstance);

        Assert.assertEquals(expectedSolution, result);

    }


}
