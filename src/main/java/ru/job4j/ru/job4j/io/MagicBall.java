package ru.job4j.ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        String input = scanner.nextLine();
        System.out.println(MagicBall.answer());

    }

    public static String answer() {
        /*return (switch (new Random().nextInt(3)) {
            case 0 -> "Да";
            case 1 -> "Нет";
            default -> "Может быть";
        }
        );
        */
        int a = new Random().nextInt(3);
        String rsl = "";
        switch (a) {
            case 0:
                rsl = "Да";
                break;
            case 1:
                rsl = "Нет";
                break;
            default:
                rsl = "Может быть";
                break;
        }
        return rsl;
    }
}
