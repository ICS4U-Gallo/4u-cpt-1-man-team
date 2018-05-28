package models;

import io.ebean.annotation.DbArray;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

public class Team {
    public String division;
    public String gender;
    @ManyToOne(cascade = CascadeType.ALL)
    public List<Sport> sport;
    public String season;
    @OneToMany(cascade = CascadeType.REMOVE)
    public List<Spot> spots;
    @ManyToOne(cascade = CascadeType.ALL)
    public LocalDateTime schoolYear;
    public String banquetInfo;
    @DbArray
    public static List<String> coaches;
    public Student MVP;
    public Student MIP;

    public String toString(){
        return division + " " + gender+ " " + sport;
    }

    public void addPlayer(Integer id) {
        addPlayer(Student.find.byId(id));
    }

    public void addPlayer(Student student) {
        Spot newPlayer = new Spot();
        newPlayer.student = student;
        spots.add(newPlayer);
    }

    public void removePlayer(Integer id) {
        removePlayer(Spot.find.byId(id));
    }

    public void removePlayer(Spot spot){
        for (int i = 0; i < spots.size(); i++){
            if (spots.get(i) == spot){
                spots.remove(i);
            }
        }
    }

    public static List<Team> findByCoach(String email){

    }
}
