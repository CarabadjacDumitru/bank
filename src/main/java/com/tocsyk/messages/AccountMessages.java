package com.tocsyk.messages;

public class AccountMessages {
    private String Account;
    private String AccountStatus;
    private String AccountBalance;
    private String AccountCreditScore;

    public String getAccountStatus() {
        return AccountStatus;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public void setAccountStatus(String accountStatus) {
        AccountStatus = accountStatus;
    }

    public String getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        AccountBalance = accountBalance;
    }

    public String getAccountCreditScore() {
        return AccountCreditScore;
    }

    public void setAccountCreditScore(String accountCreditScore) {
        AccountCreditScore = accountCreditScore;
    }
}
