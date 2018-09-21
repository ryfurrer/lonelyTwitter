package ca.ualberta.cs.lonelytwitter;
/**
 * This class code is taken from the lab TAs, as an example done in class. It is
 * included due to TA requirements seen in their eclass post:
 * https://eclass.srv.ualberta.ca/mod/forum/discuss.php?d=1035817
 * Their code can be found here: https://github.com/Rosevear/lonelyTwitter
 */


import java.util.Date;

public interface Tweetable {
    String getMessage();
    Date getDate();
}