package models;

import io.ebean.Finder;

import javax.persistence.Entity;

@Entity
public class Student extends BaseModel{
    public static Finder<Integer, Student> find = new Finder<>(Student.class);
}
