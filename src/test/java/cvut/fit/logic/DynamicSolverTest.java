package cvut.fit.logic;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.Thing;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Samuel Butta
 */
public class DynamicSolverTest {
    @Test
    public void solve() throws Exception {

        Solver solver = new DynamicSolver();


        ProblemInstance problemInstance = new ProblemInstance();
        problemInstance.setCount(4);
        problemInstance.setCapacity(100);


        List<Thing> things = new ArrayList<>();
        things.add(new Thing(18, 114));
        things.add(new Thing(42, 136));
        things.add(new Thing(88, 192));
        things.add(new Thing(3, 223));

        problemInstance.setThings(things);
        problemInstance.setExpectedResult(473);

        //System.out.println(problemInstance.getPriceForOption());

        solver.solve(problemInstance);

    }

}