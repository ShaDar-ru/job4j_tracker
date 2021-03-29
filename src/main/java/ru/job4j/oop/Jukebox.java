package ru.job4j.oop;

public class Jukebox {
    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.music(1);
        jukebox.music(15);
        jukebox.music(2);
    }

    public void music(int position) {
        String nl = System.lineSeparator();
        /*System.out.println(
                switch (position) {
                    case 1 -> "Пусть бегут неуклюже," + nl +
                            "Пешеходы по лужам," + nl +
                            "А вода по асфальту рекой." + nl +
                            "И неясно прохожим," + nl +
                            "В этот день непогожий," + nl +
                            "Почему я весёлый такой." + nl;
                    case 2 -> "Спят усталые игрушки, книжки спят," + nl +
                            "Одеяла и подушки ждут ребят." + nl +
                            "Даже сказка спать ложится," + nl +
                            "Чтобы ночью нам присниться." + nl +
                            "Ты ей пожелай: «Баю-бай!»" + nl;
                    default -> "Песня не найдена." + nl;
                }
        );*/
        String rsl = "";
        switch (position) {
            case 1:
                rsl = "Пусть бегут неуклюже," + nl
                        + "Пешеходы по лужам," + nl
                        + "А вода по асфальту рекой." + nl
                        + "И неясно прохожим," + nl
                        + "В этот день непогожий," + nl
                        + "Почему я весёлый такой." + nl;
                break;
            case 2:
                rsl = "Спят усталые игрушки, книжки спят," + nl
                        + "Одеяла и подушки ждут ребят." + nl
                        + "Даже сказка спать ложится," + nl
                        + "Чтобы ночью нам присниться." + nl
                        + "Ты ей пожелай: «Баю-бай!»" + nl;
                break;
            default:
                rsl = "Песня не найдена." + nl;
                break;
        }
        System.out.println(rsl);
    }
}

