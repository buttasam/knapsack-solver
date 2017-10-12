package cvut.fit.entity;

/**
 * @author Samuel Butta
 */
public class Thing {

    private int price;
    private int weight;

    public Thing(int weight, int price) {
        this.weight = weight;
        this.price = price;
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
