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


    public long stop() {
        long stopped = System.currentTimeMillis();
        long duration = (stopped - started);
        System.out.println(instance + " ---- time: " + duration);

        return duration;
    }

}
