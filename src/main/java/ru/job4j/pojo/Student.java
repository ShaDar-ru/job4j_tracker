package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String group;
    private String[] fio;
    private String name;
    private String surname;
    private String patronymic;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFio() {
        setFio(name, patronymic, surname);
        return atString(fio);
    }

    private String atString(String[] fio) {
        String fioStr = null;
        for (String s : fio) {
            if (fioStr == null) {
                fioStr = s;
            } else {
                fioStr = fioStr + " " + s;
            }
        }
        return fioStr;
    }

    private void setFio(String name, String patronymic, String surname) {
        fio = new String[]{name, patronymic, surname};
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void getInfo() {
        System.out.println(getFio());
        System.out.println(getGroup());
        System.out.println(getDate());

    }
}
