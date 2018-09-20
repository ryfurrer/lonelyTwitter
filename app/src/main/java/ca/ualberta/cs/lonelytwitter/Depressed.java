package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by rfurrer on 9/20/18.
 */

public class Depressed extends Mood {
    public Depressed() {
        super();
    }

    public Depressed(Date date) {
        super(date);
    }
    String emote() {
        return "☹️";
    }
}
