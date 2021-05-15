package ru.job4j.calc;

import java.util.Scanner;

public class Input {
    private String text;

    public String getText() {
        in();
        return text;
    }

    public void in() {
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();
    }
}
