package cvut.fit.logic;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.ProblemSolution;
import cvut.fit.entity.Thing;

/**
 * @author Samuel Butta
 */
public class DynamicSolver implements Solver {

    private int[][] table;
    private int sumPrice;
    private int thingsCount;

    private ProblemInstance problemInstance;

    @Override
    public ProblemSolution solve(ProblemInstance problemInstance) {
        this.problemInstance = problemInstance;
        // maximalni mozna cena
        sumPrice = problemInstance.pricesSum() + 1;
        thingsCount = problemInstance.getThings().size() + 1;

        table = new int[thingsCount][sumPrice];

        // nastaveni defaultnich hodnot
        setDefaultValues();

        // vyplneni tabulku
        fillTable();

        int bestPrice = findResult();

        ProblemSolution solution = new ProblemSolution();
        solution.setMaxPrice(bestPrice);

        return solution;
    }


    public void setDefaultValues() {
        for (int i = 1; i < sumPrice; i++) {
            table[0][i] = Integer.MAX_VALUE;
        }
    }

    public void fillTable() {
        for (int i = 1; i < thingsCount; i++) {
            for (int j = 1; j < sumPrice; j++) {
                table[i][j] = fillCell(i, j);
            }
        }
    }

    private int fillCell(int thingIndex, int priceIndex) {
        int leftOperator = findLeftOperator(thingIndex, priceIndex);
        int rightOperator = findRightOperator(thingIndex, priceIndex);

        return Math.min(leftOperator, rightOperator);
    }


    private int findLeftOperator(int thingIndex, int priceIndex) {
        return table[thingIndex - 1][priceIndex];
    }


    private int findRightOperator(int thingIndex, int priceIndex) {
        Thing thing = problemInstance.getThings().get(thingIndex - 1);
        int operator;
        if ((priceIndex - thing.getPrice() < 0)) {
            operator = Integer.MAX_VALUE;
        } else {
            operator = table[thingIndex - 1][priceIndex - thing.getPrice()] + thing.getWeight();
            if (operator < 0) operator = Integer.MAX_VALUE;
        }
        return operator;
    }


    public int findResult() {
        for (int i = sumPrice - 1; i > 0; i--) {
            int tmpResult = table[thingsCount - 1][i];
            if (tmpResult <= problemInstance.getCapacity()) {
/*                System.out.println("result weight: " + tmpResult);
                System.out.println("result price: " + i);*/
                return i;
            }
        }
        // nemelo by nastat
        throw new RuntimeException();
    }

}
