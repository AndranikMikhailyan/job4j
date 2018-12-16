package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Bank {
    private TreeMap<User, List<Account>> users = new TreeMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : this.users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getValue().add(account);
                break;
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : this.users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getValue().remove(entry.getValue().indexOf(account));
                break;
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        ArrayList<Account> result = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : this.users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                result = (ArrayList<Account>) entry.getValue();
                break;
            }
        }
        return result;
    }

    public boolean containUser(String passport) {
        boolean result = false;
        for (Map.Entry<User, List<Account>> entry : this.users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean userContainAccount(String passport, String requisite) {
        boolean result = false;
        List<Account> accounts = getUserAccounts(passport);
        for (Account account : accounts) {
            if (requisite.equals(account.getRequisites())) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean amountValid(String passport, double amount) {
        boolean result = false;
        List<Account> accounts = getUserAccounts(passport);
        for (Account account : accounts) {
            if (amount <= account.getValue()) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                  String destPassport, String dstRequisite, double amount) {
        boolean checkSrsUser = containUser(srcPassport);
        boolean checkDestUser = containUser(destPassport);
        boolean checkSrsAccount = userContainAccount(srcPassport, srcRequisite);
        boolean checkDestAccount = userContainAccount(destPassport, dstRequisite);
        boolean checkSrcAmount = amountValid(srcPassport, amount);
        return checkSrsUser && checkDestUser && checkSrsAccount && checkDestAccount && checkSrcAmount;
    }
}
