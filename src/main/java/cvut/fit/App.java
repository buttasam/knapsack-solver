package cvut.fit;

import cvut.fit.file.Reader;

/**
 * @author Samuel Butta
 */
public class App {

    public static void main(String[] args) {
        Reader reader = new Reader("data");
        reader.readInstanceFiles();
        reader.readSolutionFiles();
    }

}
