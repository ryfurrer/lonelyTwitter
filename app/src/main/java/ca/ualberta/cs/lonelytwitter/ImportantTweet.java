package ca.ualberta.cs.lonelytwitter;

import java.util.List;

/**
 * This class code is taken from the lab TAs, as an example done in class. It is
 * included due to TA requirements seen in their eclass post:
 * https://eclass.srv.ualberta.ca/mod/forum/discuss.php?d=1035817
 * Their code can be found here: https://github.com/Rosevear/lonelyTwitter
 */


public class ImportantTweet<T extends Mood>  extends Tweet {

    //Empty argument constructor with default values
    ImportantTweet() {
        //Call the parent constructor to: avoid duplication!
        super();
    }

    ImportantTweet(String message) {
        super(message);
    }

    ImportantTweet(String message, List<T> moods) {
        super(message, moods);
    }

    @Override
    public Boolean isImportant() {
        return true;
    }
}
