package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс реализует банковские операции
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных осуществляется в коллекции HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя к HashMap
     * и генерирует 2й атрибут в виде ArrayList
     * @param user - входящий пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод ищет пользователя по паспорту, и
     * если хранилище содержит пасспорт, но не содержит
     * текущий аккаунт, то добавляет его.
     * @param passport - пасспорт, по котором
     * ищут пользователя
     * @param account - аккаунт, который добавляется
     * в хранилище.
     */
    public void addAccount(String passport, Account account) {
        User searchedUser = findByPassport(passport);
        if (searchedUser != null) {
            if (!users.get(searchedUser).contains(account)) {
                users.get(searchedUser).add(account);
            }
        }
    }

    /**
     * Метод реализует поиск по хранилищу,
     * проверяя, существует ли пользователь
     * с пасспортом, принимаемым в метод
     * @param passport - паспорт пользователя,
     * по которому осуществляется поиск.
     * @return возвращает Пользователя,
     * из хранилища или null если паспорта
     * нет в хранилище
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User usersKey : users.keySet()) {
            if (usersKey.getPassport().equals(passport)) {
                rsl = usersKey;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод поиска Аккаунта по паспорту и реквизитам,
     * если найдейнный user не null
     * @param passport - пассорт по которому производится
     * поиск пользователя
     * @param requisite - реквизиты, по которым происходит
     * поиск аккаунта
     * @return аккаунт, содержащий в себе входящие реквизиты,
     * либо null
     */
    public Account findByRequisite(String passport, String requisite) {
        User searchedUser = findByPassport(passport);
        if (searchedUser != null) {
            List<Account> accounts = users.get(searchedUser);
            for (Account acc : accounts) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

    /**
     * Метод реализует передачу средств из поля amount
     * между аккаунтами, найденным по входящим полям :
     * @param srcPassport - паспорт источника передачи
     * @param srcRequisite - реквизиты аккаунта источника
     * @param destPassport - паспорт приемника
     * @param destRequisite - реквизиты приемника
     * @param amount - количество единиц передаваемых между аккаунтами ;
     * и возвращает :
     * @return true, если передача состоялась,
     * или false, при отсутсвии входных данных в хранилище или
     * при отсутсвии требуемой суммы на аккаунте источника
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc == null || destAcc == null || srcAcc.getBalance() < amount) {
            return false;
        }
        srcAcc.setBalance(srcAcc.getBalance() - amount);
        destAcc.setBalance(destAcc.getBalance() + amount);
        return true;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
    }
}