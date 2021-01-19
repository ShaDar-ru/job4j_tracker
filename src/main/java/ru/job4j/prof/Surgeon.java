package ru.job4j.prof;

public class Surgeon extends Doctor {
    private int personalcemetery;
    private String doping;

    public int getPersonalcemetery() {
        return personalcemetery;
    }

    public String getDoping() {
        return doping;
    }

    public Surgeon(
            String name,
            String education,
            int patients,
            String speciality,
            int personalcemetery,
            String doping
    ) {
        super(name, education, patients, speciality);
        this.personalcemetery = personalcemetery;
        this.doping = doping;
    }
}
