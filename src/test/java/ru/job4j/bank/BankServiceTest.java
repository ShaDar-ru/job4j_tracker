package ru.job4j.bank;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434").get(), is(user));
    }

    @Test
    public void addInvalidUser() {
        User user = new User("3434", "Petr");
        User user2 = new User("3434", "Vasya");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addUser(user2);
        assertThat(bank.findByPassport("3434").get(), is(user));
    }

    @Test
    public void addInvalidNullUser() {
        User user = new User("1212", "Leva");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434").isPresent(), is(false));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("34", "5546"), is(Optional.empty()));
    }

    @Test
    public void whenEnterInvalidRequisite() {
        User user = new User("3434", "Petr");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5547"), is(Optional.empty()));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("5542", 0));
        bank.transferMoney("3434", "5546", "3434", "5542", 120);
        assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(30D));
    }
}