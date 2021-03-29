package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            String matchesStr = notNull();
            int matches = goodInt(matchesStr);
            count = count - matches;
            if (count > 0) {
                System.out.println("Осталось " + count + " спичек.");
            }
            turn = !turn;
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }

    public static String notNull() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        while (str.trim().isEmpty()) {
            System.out.println("Ошибка ввода. Нельзя пропускать ход."
                    + System.lineSeparator() + "Введите число от 1 до 3:");
            str = in.nextLine();
        }
        return str;
    }

    public static int goodInt(String str) {
        int rsl = Integer.parseInt(str);
        while (rsl < 1 || rsl > 3) {
            System.out.println("Ошибка ввода. Число должно быть от 1 до 3."
                    + System.lineSeparator() + "Введите число от 1 до 3:");
            rsl = Integer.parseInt(notNull());
        }
        return rsl;
    }
}