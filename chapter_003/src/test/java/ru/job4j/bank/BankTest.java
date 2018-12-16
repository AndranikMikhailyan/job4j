package ru.job4j.bank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankTest {

    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "0713845698");
        bank.addUser(user);
        assertThat(bank.containUser("0713845698"), is(true));
    }

    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "0713845698");
        bank.addUser(user);
        bank.deleteUser(user);
        assertThat(bank.containUser("0713845698"), is(false));
    }

    @Test
    public void whenAddAccountToUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "0713845698");
        bank.addUser(user);
        Account account = new Account("123123123");
        bank.addAccountToUser("0713845698", account);
        assertThat(bank.userContainAccount("0713845698", "123123123"), is(true));
    }

    @Test
    public void whenDeleteAccountFromUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "0713845698");
        bank.addUser(user);
        Account account = new Account("123123123");
        bank.addAccountToUser("0713845698", account);
        bank.deleteAccountFromUser("0713845698", account);
        assertThat(bank.userContainAccount("0713845698", "123123123"), is(false));
    }

    @Test
    public void whenGetUserAccounts() {
        Bank bank = new Bank();
        User user = new User("Ivan", "0713845698");
        bank.addUser(user);
        Account account1 = new Account("123123123");
        Account account2 = new Account("123123124");
        bank.addAccountToUser("0713845698", account1);
        bank.addAccountToUser("0713845698", account2);
        assertThat(bank.getUserAccounts(user.getPassport()), is(Arrays.asList(account1, account2)));
    }

    @Test
    public void whenTransferMoney() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "0713845698");
        User user2 = new User("Roman", "0713845699");
        bank.addUser(user1);
        bank.addUser(user2);
        Account account1 = new Account("123123123");
        account1.setValue(1000);
        Account account2 = new Account("123123124");
        account1.setValue(1000);
        bank.addAccountToUser("0713845698", account1);
        bank.addAccountToUser("0713845699", account2);
        assertThat(bank.transferMoney(
                "0713845698", "123123123",
                "0713845699", "123123124", 500), is(true));
    }
}
