package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job jobObject1 = new Job();
        Job jobObject2 = new Job();
        assertNotEquals("spec for unique id assigned for each object",jobObject1.getId(),jobObject2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job jobObject = new Job("Product tester",new Employer("ACME"),new Location("Desert"),
                new PositionType("Quality control"),new CoreCompetency("Persistence"));
        assertTrue("jobObject is an object of Job class",jobObject instanceof Job);
        assertTrue("constructor correctly assigns the class of employer field",
                new Employer("ACME") instanceof Employer);
        assertTrue("constructor correctly assigns the class of location field",
                new Location("Desert") instanceof Location);
        assertTrue("constructor correctly assigns the class of positionType field",
                new PositionType("Quality control") instanceof PositionType);
        assertTrue("constructor correctly assigns the class of coreCompetency field",
                new CoreCompetency("Persistence") instanceof CoreCompetency);

        assertEquals("constructor correctly assigns the value of name field",
                jobObject.getName(),"Product tester");
        assertEquals("constructor correctly assigns the value of employer field",
                jobObject.getEmployer().getValue(),"ACME");
        assertEquals("constructor correctly assigns the value of location field",
                jobObject.getLocation().getValue(),"Desert");
        assertEquals("constructor correctly assigns the value of positionType field",
                jobObject.getPositionType().getValue(),"Quality control");
        assertEquals("constructor correctly assigns the value of coreCompetency field",
                jobObject.getCoreCompetency().getValue(),"Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job jobObject1 = new Job("Product tester",new Employer("ACME"),new Location("Desert"),
                new PositionType("Quality control"),new CoreCompetency("Persistence"));
        Job jobObject2 = new Job("Product tester",new Employer("ACME"),new Location("Desert"),
                new PositionType("Quality control"),new CoreCompetency("Persistence"));
        assertFalse("test two objects are NOT equal when their id differs",
                jobObject1.equals(jobObject2));
        assertFalse("test two objects are NOT equal when their id differs",
                jobObject1.getId() == jobObject2.getId());
    }
}
