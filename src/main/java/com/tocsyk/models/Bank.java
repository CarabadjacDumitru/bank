package com.tocsyk.models;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private int BankID;
    private Contact BankInfo;
    private String BankName;
    private Address BranchAddress;
    private List<Branch> BranchCollection;

    public Bank(String bankName, Contact bankInfo) {
        setBankID();
        this.BankName = bankName;
        this.BankInfo = bankInfo;
        this.BranchCollection = new ArrayList<Branch>();
    }

    public int getBankID() {
        return BankID;
    }

    private void setBankID() {
        BankID = Sequence.getBankSeq();
    }

    public Contact getBankInfo() {
        return BankInfo;
    }

    public void setBankInfo(Contact bankInfo) {
        BankInfo = bankInfo;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        if (StringUtils.isEmpty(bankName)) {
            throw new IllegalArgumentException("BankName");
        } else
            BankName = bankName;
    }

    public Address getBranchAddress() {
        return BranchAddress;
    }

    public void setBranchAddress(Address branchAddress) {
        BranchAddress = branchAddress;
    }

    public List<Branch> getBranchCollection() {
        return BranchCollection;
    }

    public void setBranchCollection(List<Branch> branchCollection) {
        BranchCollection = branchCollection;
    }

/*
public bool IsNull()
{
return this.BankID == 0;
}


*/
}

