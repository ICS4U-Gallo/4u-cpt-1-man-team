package models;

import io.ebean.Finder;
import io.ebean.annotation.DbArray;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseModel{
    public String division;
    public String gender;

    // team only needs one sport
    @ManyToOne(cascade = CascadeType.ALL)
    public String sport;
    public String season;
    @OneToMany(cascade = CascadeType.REMOVE)
    public List<Spot> spots = new ArrayList<>();
    public LocalDateTime schoolYear;
    public String banquetInfo;
    @DbArray
    public List<String> coaches = new ArrayList<>();
    public Student MVP;
    public Student MIP;

    //For testing purposes
    public Team(String division, String gender, String sport){
        this.division = division;
        this.gender = gender;
        this.sport = sport;
    }

    public String toString(){
        return division + " " + gender+ " " + sport;
    }

    public void addPlayer(Integer id) {
        addPlayer(Student.find.byId(id));
    }

    public void addPlayer(Student student) {
        Spot newPlayer = new Spot(student);
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

    public static Finder<Integer, Team> find = new Finder<>(Team.class);

    public static List<Team> findByCoach(String email){
        return find.query().where().contains("coaches", email).findList();
    }
}
