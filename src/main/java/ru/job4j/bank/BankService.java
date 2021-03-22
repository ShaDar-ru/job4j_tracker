package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
        /*
        boolean rsl = true;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().equals(user)) {
                rsl = false;
                break;
            }
        }
        if (rsl) {
            users.put(user, new ArrayList<>());
        }*/
    }

    public void addAccount(String passport, Account account) {
        User searchedUser = findByPassport(passport);
        users.get(searchedUser).add(account);
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (Map.Entry<User, List<Account>> usrs : users.entrySet()) {
            if (usrs.getKey().getPassport().equals(passport)) {
                rsl = usrs.getKey();
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User searchedUser = findByPassport(passport);
        for (Map.Entry<User, List<Account>> usrs : users.entrySet()) {
            if (usrs.getKey().equals(searchedUser)) {
                for (Account acc : usrs.getValue()) {
                    if (acc.getRequisite().equals(requisite)) {
                        rsl = acc;
                    }
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.getBalance() < amount) {
            return false;
        } else {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            return true;
        }
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