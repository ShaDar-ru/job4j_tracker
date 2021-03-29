package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных аккаунта пользователя
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 */
public class Account {
    /**
     * Поле для хранения реквизитов в Аккаунте
     */
    private String requisite;
    /**
     * Поле для хранения баланса текущего Аккаунта
     */
    private double balance;

    /**
     * Конструктор аккаунта
     * @param requisite - реквизиты нового аккаунта
     * @param balance - баланс на данном аккаунте
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод получения реквизитов
     * @return реквизиты аккаунта
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод установки реквизитов
     * @param requisite - ревизиты аккаунта
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод получения баланса
     * @return баланс аккаунта
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод установки баланса
     * @param balance - баланс аккаунта
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод
     * определения hash-суммы
     * @return хеш-суммы реквизитов
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }

    /**
     * Переопределение метода сравнения
     * текущего объекта с объектом
     * @param obj объект, с которым сравнивают
     * @return true если объекты идентичны, или их реквизиты идентичны,
     * иначе false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Account account = (Account) obj;
        return Objects.equals(requisite, account.requisite);
    }
}
