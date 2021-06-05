package ru.job4j.bank;

import java.util.*;

/**
 * Класс реализует банковские операции
 *
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
     *
     * @param user - входящий пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод ищет пользователя по паспорту, и
     * если хранилище содержит пасспорт, но не содержит
     * текущий аккаунт, то добавляет его.
     *
     * @param passport - пасспорт, по котором
     *                 ищут пользователя
     * @param account  - аккаунт, который добавляется
     *                 в хранилище.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> optUser = findByPassport(passport);
        if (optUser.isPresent()) {
            if (!users.get(optUser.get()).contains(account)) {
                users.get(optUser.get()).add(account);
            }
        }
    }

    /**
     * Метод реализует поиск по хранилищу,
     * проверяя, существует ли пользователь
     * с пасспортом, принимаемым в метод
     *
     * @param passport - паспорт пользователя,
     *                 по которому осуществляется поиск.
     * @return возвращает Пользователя,
     * из хранилища или null если паспорта
     * нет в хранилище
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод поиска Аккаунта по паспорту и реквизитам,
     * если найдейнный user не null
     *
     * @param passport  - пассорт по которому производится
     *                  поиск пользователя
     * @param requisite - реквизиты, по которым происходит
     *                  поиск аккаунта
     * @return аккаунт, содержащий в себе входящие реквизиты,
     * либо null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> optUser = findByPassport(passport);
        return optUser.flatMap(user -> users.get(user)
                .stream()
                .filter(acc -> acc.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод реализует передачу средств из поля amount
     * между аккаунтами, найденным по входящим полям :
     *
     * @param srcPassport   - паспорт источника передачи
     * @param srcRequisite  - реквизиты аккаунта источника
     * @param destPassport  - паспорт приемника
     * @param destRequisite - реквизиты приемника
     * @param amount        - количество единиц передаваемых между аккаунтами ;
     *                      и возвращает :
     * @return true, если передача состоялась,
     * или false, при отсутсвии входных данных в хранилище или
     * при отсутсвии требуемой суммы на аккаунте источника
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAccOpt = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccOpt = findByRequisite(destPassport, destRequisite);
        if (srcAccOpt.isEmpty() || destAccOpt.isEmpty() || srcAccOpt.get().getBalance() < amount) {
            return false;
        }
        srcAccOpt.get().setBalance(srcAccOpt.get().getBalance() - amount);
        destAccOpt.get().setBalance(destAccOpt.get().getBalance() + amount);
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