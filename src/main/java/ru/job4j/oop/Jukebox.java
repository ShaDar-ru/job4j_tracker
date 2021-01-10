package ru.job4j.oop;

public class Jukebox {
    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.music(1);
        jukebox.music(15);
        jukebox.music(2);
    }

    public void music(int position) {
        System.out.println(
                switch (position) {
                    case 1 -> "Пусть бегут неуклюже,\n" +
                            "Пешеходы по лужам,\n" +
                            "А вода по асфальту рекой.\n" +
                            "И неясно прохожим,\n" +
                            "В этот день непогожий,\n" +
                            "Почему я весёлый такой.\n";
                    case 2 -> "Спят усталые игрушки, книжки спят, \n" +
                            "Одеяла и подушки ждут ребят.\n" +
                            "Даже сказка спать ложится, \n" +
                            "Чтобы ночью нам присниться.\n" +
                            "Ты ей пожелай: «Баю-бай!»\n";
                    default -> "Песня не найдена.\n";
                }
        );
    }
}
