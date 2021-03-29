package ru.job4j.prof;

public class Engineer extends Profession {
    private int patents;
    private int projects;

    public Engineer(String name, String education, int patents, int projects) {
        super(name, education);
        this.patents = patents;
        this.projects = projects;
    }

    public int getPatents() {
        return patents;
    }

    public int getProjects() {
        return projects;
    }
}
