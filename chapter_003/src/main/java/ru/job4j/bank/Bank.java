package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

public class Bank {
    private TreeMap<User, List<Account>> users = new TreeMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        this.users.forEach((user, accounts) -> {
            if (user.getPassport().equals(passport)) {
                accounts.add(account);
            }
        });
    }

    public void deleteAccountFromUser(String passport, Account account) {
        this.users.forEach((user, accounts) -> {
            if (user.getPassport().equals(passport)) {
                if (accounts.contains(account)) {
                    accounts.remove(account);
                }
            }
        });
    }

    public List<Account> getUserAccounts(String passport) {
        ArrayList<Account> result = new ArrayList<>();
        this.users.forEach((user, accounts) -> {
            if (user.getPassport().equals(passport)) {
                result.addAll(accounts);
            }
        });
        return result;
    }

    public boolean containUser(String passport) {
        boolean result = this.users.entrySet().stream().anyMatch(
                userListEntry -> userListEntry.getKey().getPassport().equals(passport)
        );
        return result;
    }

    public Optional<Account> userContainAccount(String passport, String requisite) {
        return this.getUserAccounts(passport).stream().findAny().filter(
                account -> requisite.equals(account.getRequisites()));
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Optional<Account> src = userContainAccount(srcPassport, srcRequisite);
        Optional<Account> dest = userContainAccount(destPassport, dstRequisite);
        if (src.isPresent() && dest.isPresent()) {
            result = src.get().transfer(dest.get(), amount);
        }
        return result;
    }
}
