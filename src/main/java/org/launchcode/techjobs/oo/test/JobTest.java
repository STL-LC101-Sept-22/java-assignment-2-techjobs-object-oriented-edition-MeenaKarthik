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

        assertTrue(jobObject instanceof Job);
        assertTrue(new Employer("ACME") instanceof Employer);
        assertTrue(new Location("Desert") instanceof Location);
        assertTrue(new PositionType("Quality control") instanceof PositionType);
        assertTrue(new CoreCompetency("Persistence") instanceof CoreCompetency);

        assertEquals("Product tester", jobObject.getName());
        assertEquals("ACME", jobObject.getEmployer().getValue());
        assertEquals("Desert", jobObject.getLocation().getValue());
        assertEquals("Quality control", jobObject.getPositionType().getValue());
        assertEquals("Persistence", jobObject.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job jobObject1 = new Job("Product tester",new Employer("ACME"),new Location("Desert"),
                new PositionType("Quality control"),new CoreCompetency("Persistence"));
        Job jobObject2 = new Job("Product tester",new Employer("ACME"),new Location("Desert"),
                new PositionType("Quality control"),new CoreCompetency("Persistence"));
        assertFalse(jobObject1.equals(jobObject2));
        /*assertFalse("test two objects are NOT equal when their id differs",
                jobObject1.getId() == jobObject2.getId())*/;
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobObject = new Job("Product tester",new Employer("ACME"),new Location("Desert"),
                new PositionType("Quality control"),new CoreCompetency("Persistence"));
        String jobData = jobObject.toString();
        //System.out.println("job data: "+jobData);
        assertEquals('\n', jobData.charAt(0));
        assertEquals('\n', jobData.charAt(jobData.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobObject = new Job("Product tester",new Employer("ACME"),new Location("Desert"),
                new PositionType("Quality control"),new CoreCompetency("Persistence"));
        String jobData = jobObject.toString();
        //System.out.println("job data: "+jobData);
        assertEquals("\nID: "+jobObject.getId()+"\n"+
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n",
                jobData);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job jobObject1 = new Job("",new Employer("ACME"),new Location("Desert"),
                new PositionType(""),new CoreCompetency("Persistence"));
        Job jobObject2 = new Job("",new Employer(""),new Location(""),
                new PositionType(""),new CoreCompetency(""));

        String jobData = jobObject1.toString();
        System.out.println("job data: "+jobData);
        assertEquals("\nID: "+jobObject1.getId()+"\n"+
                        "Name: Data not available\n" +
                        "Employer: ACME\n" +
                        "Location: Desert\n" +
                        "Position Type: Data not available\n" +
                        "Core Competency: Persistence\n",
                jobData);

        jobData = jobObject2.toString();
        System.out.println("job data: "+jobData);
        assertEquals("OOPS! This job does not seem to exist.",
                jobData);
    }

}
