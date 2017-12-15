package cvut.fit.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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


    private List<Boolean> option = new ArrayList<>();

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


    public List<Boolean> getOption() {
        return option;
    }

    public void setOption(List<Boolean> option) {
        this.option = option;
    }


    public int getPriceForOption() {
        int price = 0;
        for(int i = 0; i < option.size(); i++) {
            if(option.get(i)) {
                price += things.get(i).getPrice();
            }
        }
        return price;
    }


    public int getWeightForOption() {
        int weight = 0;
        for(int i = 0; i < option.size(); i++) {
            if(option.get(i)) {
                weight += things.get(i).getWeight();
            }
        }
        return weight;
    }


    public int sumPriceForRamainingThings() {
        int price = 0;
        for(int i = option.size(); i < things.size(); i++) {
                price += things.get(i).getPrice();
        }
        return price;
    }


    public boolean capacityOverflow() {
        return (getWeightForOption() > capacity);
    }


    public int pricesSum() {
        return things.stream().mapToInt(Thing::getPrice).sum();
    }

    public int maxPrice() {
        return things.stream().mapToInt(Thing::getPrice).max().getAsInt();
    }

    public void setRandomOption() {
        List<Boolean> option = new ArrayList<>();

        for(int i = 0; i < things.size(); i++) {
            Random random = new Random();
            if(random.nextInt() % 2 == 0) {
                option.add(true);
            } else {
                option.add(false);
            }
        }
        setOption(option);
    }

    public void setRandomValidOption() {
        setRandomOption();
        while(capacityOverflow()) {
            setRandomOption();
        }
    }

}
