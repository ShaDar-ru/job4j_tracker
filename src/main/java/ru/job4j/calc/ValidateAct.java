package ru.job4j.calc;

public class ValidateAct {
    private String text;

    public ValidateAct(String text) {
        this.text = text;
    }

    public String getValidAct() throws InputErrorException {
        String s = text.replaceAll("[A-Za-z0-9]", "");
        if (s.length() != 1) {
            throw new InputErrorException();
        }
        return s;
    }
}
