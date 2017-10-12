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
    List<Boolean> results = new ArrayList<>();


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

    public List<Boolean> getResults() {
        return results;
    }

    public void setResults(List<Boolean> results) {
        this.results = results;
    }


    public void addResult(Boolean result) {
        this.results.add(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProblemSolution that = (ProblemSolution) o;

        if (id != that.id) return false;
        if (count != that.count) return false;
        if (maxPrice != that.maxPrice) return false;
        return results != null ? results.equals(that.results) : that.results == null;
    }

}
