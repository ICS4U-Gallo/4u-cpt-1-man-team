package models;

import org.junit.*;
import play.test.WithApplication;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static play.test.Helpers.*;

public class TeamModelTest extends WithApplication{

    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void testCanSaveAndFindTeam() {
        new Team("Junior", "Male").save();
        Team team = Team.find.query().where()
                .eq("division", "Junior")
                .findOne();
        assertEquals("Junior", team.division);
        assertEquals("Male", team.gender);
    }

    @Test
    public void testToString() {
        Team team = new Team("Senior", "Female");
        Sport sport = new Sport("Basketball", 5);
        List<Sport> sportList = new ArrayList<>();
        sportList.add(sport);
        team.sport = sportList;
        team.toString();
        assertEquals("Senior Female Sport", team.toString());
    }

    @Test
    public void testAddPlayer() {
        Student student1 = new Student();
        Spot player1 = new Spot(student1);
        Student student2 = new Student();
        Spot player2 = new Spot(student2);
        Student student3 = new Student();
        Spot player3 = new Spot(student3);

        Team team = new Team("", "");

        // init in class, remove from here
        team.spots = new ArrayList<>();

        team.spots.add(player1);
        team.spots.add(player2);
        team.addPlayer(student3);

    }

}
