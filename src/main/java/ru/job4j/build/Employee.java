package ru.job4j.build;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 11.05.2021
 */
public class Employee {
    protected String name;
    protected String position;
    protected int age;
    protected int experience;
    protected boolean isLeader;
    protected String projectName;
    protected int projectCode;

    @Override
    public String toString() {
        return "Employee{"
                + "name='" + name + '\''
                + ", position='" + position + '\''
                + ", age=" + age
                + ", experience=" + experience
                + ", isLeader=" + isLeader
                + ", projectName='" + projectName + '\''
                + ", projectCode=" + projectCode
                + '}';
    }
}
