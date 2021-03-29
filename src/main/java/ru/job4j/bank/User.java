package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных пользователя,
 * применяемой для работы банковских услуг {@link BankService}
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 */
public class User {
    /**
     * Поле для хранения пасспорта
     */
    private String passport;
    /**
     * Поле для хранения Имени пользователя
     */
    private String username;

    /**
     * Конструктор, принимающий в себя:
     * @param passport - паспорт пользователя;
     * @param username - имя пользователя;
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * @return Паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     *
     * @param passport - Прописывает паспорт
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     *
     * @return Имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username - Прописывает имя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод, возвращает
     * @return хеш по паспорту
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    /**
     * Метод, сравнивающий текущий объект с
     * @param obj иным объектом, возвращающий данные, что
     * первый объект:
     * @return -1 (меньше), 0 (равен), 1 (больше) иного.
     *
     * Сравнивает сперва идентичность объектов,
     * после, идентичны ли классы объектов,
     * после по значению passport.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return Objects.equals(passport, user.passport);
    }
}
