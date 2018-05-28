package models;

import io.ebean.Finder;

import javax.persistence.Entity;

@Entity
public class Spot {
    Team team;
    Student student;
    public static Finder<Integer, Spot> find = new Finder<>(Spot.class);
}
