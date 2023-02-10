package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job(){
        this.id = nextId;
        nextId++;
    }

    public Job(String name,Employer employer,Location location,PositionType positionType,CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //create a custom toString() to print particular job data
    @Override
    public String toString(){

        String displayName = this.getName();
        String displayEmployer = this.getEmployer().getValue();
        String displayLocation = this.getLocation().getValue();
        String displayPositionType = this.getPositionType().getValue();
        String displayCoreCompetency = this.getCoreCompetency().getValue();
        String noData = "Data not available";

        if(displayName.isEmpty()) displayName = noData;
        if(displayEmployer.isEmpty()) displayEmployer = noData;
        if(displayLocation.isEmpty()) displayLocation = noData;
        if(displayPositionType.isEmpty()) displayPositionType = noData;
        if(displayCoreCompetency.isEmpty()) displayCoreCompetency = noData;

        if(displayName.equals(noData) && displayEmployer.equals(noData) && displayLocation.equals(noData)
                && displayPositionType.equals(noData) && displayCoreCompetency.equals(noData))
        return "OOPS! This job does not seem to exist.";
        else
        return  "\nID: "+this.getId()+
            "\nName: "+displayName+
            "\nEmployer: "+displayEmployer+
            "\nLocation: "+displayLocation+
            "\nPosition Type: "+displayPositionType+
            "\nCore Competency: "+displayCoreCompetency+
            "\n";
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}
