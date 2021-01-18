package ru.job4j.prof;

public class Doctor extends Profession {
    private int patients;
    private String speciality;

    public int getPatients() {
        return patients;
    }

    public String getSpeciality() {
        return speciality;
    }

    public Doctor(
            String name,
            String education,
            int patients,
            String speciality
    ) {
        super(name, education);
        this.patients = patients;
        this.speciality = speciality;
    }
}
