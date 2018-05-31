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

//    @Test
//    public void testAddPlayer() {
//        Student student = new Student();
//        student.save();
//        Team team = new Team("", "");
//
//        team.addPlayer(student);
//        team.save();
//
//        Team result = Team.find.byId(team.id);
//        Integer id = result.spots.get(0).student.id;
//        assertEquals(student.id, id);
//    }

}
