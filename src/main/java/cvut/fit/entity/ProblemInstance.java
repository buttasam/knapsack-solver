package cvut.fit.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Samuel Butta
 */
public class ProblemInstance {

    // identifikator instance
    private int id;

    // pocet veci
    private int count;

    // nosnost batohu M
    private int capacity;

    // ceny veci
    private List<Thing> things = new ArrayList<>();


    // spravny vysledek
    private int expectedResult;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Thing> getThings() {
        return things;
    }

    public void setThings(List<Thing> things) {
        this.things = things;
    }

    public void addThing(Thing thing) {
        this.things.add(thing);
    }

    public int getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(int expectedResult) {
        this.expectedResult = expectedResult;
    }
}
