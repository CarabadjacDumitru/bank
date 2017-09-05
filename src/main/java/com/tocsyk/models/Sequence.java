package com.tocsyk.models;


public class Sequence {

    Sequence() {
        AccountSeq = 0;
        AddressSeq = 0;
        BankSeq = 0;
        BranchSeq = 0;
        CustomerSeq = 0;
        ContactSeq = 0;
        ContractSeq = 0;
        PaymentSeq = 0;
    }

    private static int AccountSeq;
    private static int AddressSeq;
    private static int BankSeq;
    private static int BranchSeq;
    private static int ContactSeq;
    private static int CustomerSeq;
    private static int ContractSeq;
    private static int PaymentSeq;

    public static int getAccountSeq() {
        return ++AccountSeq;
    }

    public static int getAddressSeq() {
        return ++AddressSeq;
    }

    public static int getBankSeq() {
        return ++BankSeq;
    }

    public static int getBranchSeq() {
        return ++BranchSeq;
    }

    public static int getContactSeq() {
        return ++ContactSeq;
    }

    public static int getCustomerSeq() {
        return ++CustomerSeq;
    }

    public static int getContractSeq() {
        return ++ContractSeq;
    }

    public static int getPaymentSeq() {
        return ++PaymentSeq;
    }
}


