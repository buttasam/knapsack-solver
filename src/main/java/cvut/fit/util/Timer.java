package cvut.fit.util;

/**
 * @author Samuel Butta
 */
public class Timer {

    private String instance;
    private final long started;

    public Timer(String instance) {
        this.instance = instance;
        started = System.currentTimeMillis();
    }


    public void stop() {
        long stopped = System.currentTimeMillis();
        //System.out.println(instance + " ---- time: " + (stopped - started));
    }

}
