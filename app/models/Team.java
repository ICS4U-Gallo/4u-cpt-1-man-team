package models;

import io.ebean.annotation.DbArray;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;

public class Team {
    public String division;
    public String gender;
    @ManyToOne(cascade = CascadeType.ALL)
    public List<Sport> sport;
    public String season;
    public List<Spot> spot;
    @ManyToOne(cascade = CascadeType.ALL)
    public LocalDateTime schoolYear;
    public String banquetInfo;
    @DbArray
    public List<String> coaches;
    public Student MVP;
    public Student MIP;

    public String toString(){
        return division + " " + gender+ " " + sport;
    }

    public void addPlayer(Student student){

    }

    public static List<Team> findByCoach(String email){
        
    }
}
