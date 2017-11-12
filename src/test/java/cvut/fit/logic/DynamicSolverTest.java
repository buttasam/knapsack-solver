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


    @Test
    public void solve10() throws Exception {

        Solver solver = new DynamicSolver();

        ProblemInstance problemInstance = new ProblemInstance();
        problemInstance.setCount(10);
        problemInstance.setCapacity(100);



        List<Thing> things = new ArrayList<>();
        things.add(new Thing(27, 38));
        things.add(new Thing(2, 86));
        things.add(new Thing(41, 112));
        things.add(new Thing(1, 0));
        things.add(new Thing(25, 66));
        things.add(new Thing(1, 97));
        things.add(new Thing(34, 195));
        things.add(new Thing(3, 85));
        things.add(new Thing(50, 42));
        things.add(new Thing(12, 223));

        problemInstance.setThings(things);
        problemInstance.setExpectedResult(798);

        //System.out.println(problemInstance.getPriceForOption());

        solver.solve(problemInstance);

    }

}