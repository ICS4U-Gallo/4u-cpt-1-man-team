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
        new Team("Junior", "Male", "Basketball").save();
        Team team = Team.find.query().where()
                .eq("division", "Junior")
                .findOne();
        assertEquals("Junior", team.division);
        assertEquals("Male", team.gender);
        assertEquals("Basketball", team.sport);
    }

    @Test
    public void testToString() {
        Team team = new Team("Senior", "Female", "Basketball");
        assertEquals("Senior Female Basketball", team.toString());
    }

    @Test
    public void testAddPlayer() {
        Student student = new Student();
        student.save();
        Team team = new Team("Senior", "Male", "Soccer");

        team.addPlayer(student.id);
        team.save();

        Integer id = team.spots.get(team.spots.size() -  1).student.id;
        assertEquals(student.id, id);
    }

    @Test
    public void testDeletePlayer(){

    }

}
