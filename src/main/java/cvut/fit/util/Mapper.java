package cvut.fit.util;

import cvut.fit.entity.ProblemInstance;
import cvut.fit.entity.Thing;

/**
 * @author Samuel Butta
 */
public class Mapper {

    public static ProblemInstance mapLineToProbleInstance(String line) {
        String[] splited = line.split("\\s+");

        ProblemInstance problemInstance = new ProblemInstance();
        problemInstance.setId(Integer.parseInt(splited[0]));
        problemInstance.setCount(Integer.parseInt(splited[1]));
        problemInstance.setCapacity(Integer.parseInt(splited[2]));

        for(int i = 3; i < splited.length; i++) {
            problemInstance.addThing(new Thing(Integer.parseInt(splited[i]), Integer.parseInt(splited[i + 1])));
            i++;
        }

        return problemInstance;
    }

}
