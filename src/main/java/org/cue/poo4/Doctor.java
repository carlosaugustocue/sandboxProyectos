package org.cue.poo4;

public class Doctor extends User {
    private String specialty;

    public Doctor(String name, String email, String password, String specialty) {
        super(name, email, password);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }

}
