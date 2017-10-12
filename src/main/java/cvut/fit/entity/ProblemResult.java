package cvut.fit.entity;

import java.util.function.Function;

/**
 * @author Samuel Butta
 */
public class ProblemResult {

    int count;
    int price;
    int weight;

    public ProblemResult(int count, int price, int weight) {
        this.count = count;
        this.price = price;
        this.weight = weight;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
