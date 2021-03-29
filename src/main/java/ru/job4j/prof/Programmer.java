package ru.job4j.prof;

public class Programmer extends Engineer {
    private String lang;
    private int petprojects;

    public Programmer(String name,
                      String education,
                      int patents,
                      int projects,
                      String lang
    ) {
        super(name, education, patents, projects);
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public int getPetprojects() {
        return petprojects;
    }
}
