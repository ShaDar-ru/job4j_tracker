package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        char start = 123;
        char end = 125;
        return '{' +
                System.lineSeparator() +
                "\t" + "\"name\" : " + "\"" + name + "\"" +
                System.lineSeparator() +
                "\t" + "\"body\" : " + "\"" + body + "\"" +
                System.lineSeparator() +
                '}';
    }

    public static void main(String[] args) {
        JSONReport report = new JSONReport();
        String text = report.generate("nameFromRame", "BodyNoBody");
        System.out.println(text);
    }
}
