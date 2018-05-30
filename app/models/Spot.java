package models;

import io.ebean.Finder;

import javax.persistence.Entity;

@Entity
public class Spot {
    Team team;
    Student student;

    //For testing purposes
    public Spot(Student student){
        this.student = student;
    }

    public static Finder<Integer, Spot> find = new Finder<>(Spot.class);
}
