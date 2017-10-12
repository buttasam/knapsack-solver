package cvut.fit.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by samik on 12.10.17.
 */
public class SetUtil {


    public static <T> Set<Set<T>> powerSet(List<T> list) {
        Set<Set<T>> sets = new HashSet<Set<T>>();
        if (list.isEmpty()) {
            sets.add(new HashSet<T>());
            return sets;
        }

        T head = list.get(0);
        List<T> rest = new ArrayList<>(list.subList(1, list.size()));
        for (Set<T> set : powerSet(rest)) {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }


}
