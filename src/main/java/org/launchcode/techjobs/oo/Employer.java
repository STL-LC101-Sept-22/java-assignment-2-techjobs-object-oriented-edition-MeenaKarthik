package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Employer extends JobField {

    //constructor
    public Employer(String value) {
        super(value);
    }

    // Custom equals method:
    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        Employer employer = (Employer) o;
        return getId() == employer.getId();
    }

}
