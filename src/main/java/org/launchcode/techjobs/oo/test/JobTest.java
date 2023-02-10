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

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobObject = new Job("Product tester",new Employer("ACME"),new Location("Desert"),
                new PositionType("Quality control"),new CoreCompetency("Persistence"));
        String jobData = jobObject.toString();
        //System.out.println("job data: "+jobData);
        assertEquals("verify first character of the toString method output is a newline character",
                '\n', jobData.charAt(0));
        assertEquals("verify last character of the toString method output is a newline character",
                '\n', jobData.charAt(jobData.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobObject = new Job("Product tester",new Employer("ACME"),new Location("Desert"),
                new PositionType("Quality control"),new CoreCompetency("Persistence"));
        String jobData = jobObject.toString();
        //System.out.println("job data: "+jobData);
        assertEquals("verify toString method outputs correct labels and data",
                "\nID: "+jobObject.getId()+"\n"+
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
        assertEquals("verify toString method handles empty field",
                "\nID: "+jobObject1.getId()+"\n"+
                        "Name: Data not available\n" +
                        "Employer: ACME\n" +
                        "Location: Desert\n" +
                        "Position Type: Data not available\n" +
                        "Core Competency: Persistence\n",
                jobData);

        jobData = jobObject2.toString();
        System.out.println("job data: "+jobData);
        assertEquals("verify toString method handles all empty fields",
                "OOPS! This job does not seem to exist.",
                jobData);
    }

}
