package cvut.fit.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Samuel Butta
 */
public class ProblemSolution {

    int id;
    int count;
    int maxPrice;

    // vektor reseni
    private List<Boolean> option = new ArrayList<>();

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

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProblemSolution that = (ProblemSolution) o;

        if (id != that.id) return false;
        if (count != that.count) return false;
        return maxPrice == that.maxPrice;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + count;
        result = 31 * result + maxPrice;
        return result;
    }

    public List<Boolean> getOption() {
        return option;
    }

    public void setOption(List<Boolean> option) {
        this.option = option;
    }
}
