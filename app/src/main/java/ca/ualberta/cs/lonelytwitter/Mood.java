package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Added three new model classes to LonelyTwitter:
 * the first should be an abstract base class which represents the current mood.
 * The second and third should be non-abstract classes which represent different moods and inherit from the ABC.
 * Each mood should have a date and getters and setters to access the date.
 * A constructor which sets the date to a default and a constructor which takes a date as an argument should be provided.
 * Encapuslation should be followed.

 * Your new code should have examples of: classes, methods, attributes, access modifiers, constructors, inheritance, abstract base classes,
 * encapsulation, polymorphism, and generic types.
 * Created by rfurrer on 9/20/18.
 */

public abstract class Mood  {
    private Date date;

    public Mood() {
        this.date = new Date();
    }

    public Mood(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    /**
     *  Each mood has a mood-dependent format method which returns a string representing the mood.
     * @return String
     */
    abstract String format();

    @Override
    public String toString(){
        return this.format();
    }
}