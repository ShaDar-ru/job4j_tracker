package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book clCode = new Book("Clean code", 500);
        Book headFirst = new Book("Head First", 250);
        Book magazine = new Book("Heals", 50);
        Book easyEnglish = new Book("Easy English", 300);

        Book[] bks = new Book[4];
        bks[0] = clCode;
        bks[1] = headFirst;
        bks[2] = magazine;
        bks[3] = easyEnglish;

        for (int i = 0; i < bks.length; i++) {
            System.out.println("name: " + bks[i].getName() + " pages: " + bks[i].getPages());
        }

        System.out.println();

        Book swap = bks[0];
        bks[0] = bks[3];
        bks[3] = swap;

        for (int i = 0; i < bks.length; i++) {
            System.out.println("name: " + bks[i].getName() + " pages: " + bks[i].getPages());
        }

        System.out.println();

        for (Book b : bks) {
            if (b.getName().equals("Clean code")) {
                System.out.println("name: " + b.getName() + " pages: " + b.getPages());
            }
        }
    }
}
