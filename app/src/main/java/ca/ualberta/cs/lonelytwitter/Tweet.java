package ca.ualberta.cs.lonelytwitter;
/**
 * This class code is taken from the lab TAs, as an example done in class. It is
 * included due to TA requirements seen in their eclass post:
 * https://eclass.srv.ualberta.ca/mod/forum/discuss.php?d=1035817
 * Their code can be found here: https://github.com/Rosevear/lonelyTwitter
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Tweet<T extends Mood> implements Tweetable {

    private Date date;
    private String message;
    private static final Integer MAX_CHARS = 140;
    private List<T> moods = new ArrayList<T>();

    //Empty argument constructor with default values
    Tweet() {
        //Must use the 'this' keyword in order to specify the current object message = message does nothing!
        this.date = new Date();
        this.message = "I am default message schwa!";
    }

    //Overloading: so that we can specify the tweet content
    Tweet(String message) {
        this.date = new Date();
        this.message = message;
    }

    //Overloading: so that we can specify the mood content
    Tweet(String message, List<T> moods) {
        this.date = new Date();
        this.message = message;
        this.moods = moods;

    }


    public List<T> getMoods() {
        return moods;
    }

    public void setMoods(List<T> moods) {
        this.moods = moods;
    }

    public String getMessage() {
        return this.message;
    }

    public String sendTweet() {
        return date.toString() + " | " + moods.toString() + " | " + this.message + "\n";
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() <= this.MAX_CHARS ) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    public Date getDate() { return this.date; }

    //No method body implemented! We leave that up to the subclasses (they MUST implement it)
    public abstract Boolean isImportant();
}

