//package ru.job4j.build;
//
///**
// * @author Alex Terentev (ShaDar-ru)
// * @version 1.0
// * @date 11.05.2021
// */
//public class Builder {
//    private String name;
//    private String position;
//    private int age;
//    private int experience;
//    private boolean isLeader;
//    private String projectName;
//    private int projectCode;
//
//    private Builder buildName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    private Builder buildPosition(String position) {
//        this.position = position;
//        return this;
//    }
//
//    private Builder buildAge(int age) {
//        this.age = age;
//        return this;
//    }
//
//    private Builder buildExperience(int experience) {
//        this.experience = experience;
//        return this;
//    }
//
//    private Builder buildIsLeader(boolean isLeader) {
//        this.isLeader = isLeader;
//        return this;
//    }
//
//    private Builder buildProjectName(String projectName) {
//        this.projectName = projectName;
//        return this;
//    }
//
//    private Builder buildProjectCode(int projectCode) {
//        this.projectCode = projectCode;
//        return this;
//    }
//
//    protected Employee build() {
//        Employee emp = new Employee();
//        emp.name = name;
//        emp.position = position;
//        emp.age = age;
//        emp.experience = experience;
//        emp.isLeader = isLeader;
//        emp.projectName = projectName;
//        emp.projectCode = projectCode;
//        return emp;
//    }
//
//    public static void main(String[] args) {
//        Employee employee = new Builder()
//                .buildName("Василий Поликарпович")
//                .buildAge(42)
//                .buildIsLeader(true)
//                .buildExperience(15)
//                .buildPosition("Ведущий инженер")
//                .buildProjectName("Разработка упаковки для макарон")
//                .buildProjectCode(12001342)
//                .build();
//        System.out.println(employee);
//    }
//}
