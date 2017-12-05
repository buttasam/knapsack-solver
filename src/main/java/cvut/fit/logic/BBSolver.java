package cvut.fit.logic;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.ProblemSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Samuel Butta
 */
public class BBSolver implements Solver {


    private int bestPrice;
    private int count;

    private ProblemInstance problemInstance;

    @Override
    public ProblemSolution solve(ProblemInstance problemInstance) {
        // vycisteni pro novy beh
        this.bestPrice = 0;

        this.problemInstance = problemInstance;
        this.count = problemInstance.getCount();

        // pole priznaku, zda je dana vec v batohu nebo ne
        List<Boolean> option = new ArrayList<>();
        solveRec(option);

        // System.out.println(bestPrice);
        ProblemSolution solution = new ProblemSolution();
        solution.setMaxPrice(bestPrice);
        //System.out.println(bestPrice);
        return solution;
    }


    public void solveRec(List<Boolean> option) {

        //System.out.println(option);
        problemInstance.setOption(option);
        int currentOptionPrice = problemInstance.getPriceForOption();

        if (problemInstance.capacityOverflow()) {
            return;
        }

        if (bestPrice < currentOptionPrice) {
            bestPrice = problemInstance.getPriceForOption();
        }

        // oriznuti pokud jiz neni mozne nalezt lepsi cenu
        if (bestPrice > (currentOptionPrice + problemInstance.sumPriceForRamainingThings())) {
            return;
        }

        if (option.size() == count) {
            // konec rekurze
            return;
        }


        // moznost s pridanim nasledujici veci
        solveRec(copyBooleanList(option, true));
        // moznost s nepridanim nasledujici veci
        solveRec(copyBooleanList(option, false));
    }


    private List<Boolean> copyBooleanList(List<Boolean> option, Boolean last) {
        List<Boolean> cloneOptions = new ArrayList<>();

        for (Boolean b : option) {
            cloneOptions.add(b);
        }
        cloneOptions.add(last);

        return cloneOptions;
    }

}
