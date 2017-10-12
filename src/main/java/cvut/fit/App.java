package cvut.fit;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.file.Reader;
import cvut.fit.logic.BruteForceSolver;
import cvut.fit.logic.HeuristicSolver;
import cvut.fit.logic.Solver;

import java.util.List;

/**
 * @author Samuel Butta
 */
public class App {

    public static void main(String[] args) {
        Reader reader = new Reader("data");
        // reader.readInstanceFiles();
        // reader.readSolutionFiles();

        List<ProblemInstance> instances = reader.readInstanceFile("knap_04.inst.dat");

        Solver solver = new HeuristicSolver();


        instances.stream().map(i -> solver.solve(i)).forEach(problemSolution -> System.out.println(problemSolution.getMaxPrice()));
    }

}
