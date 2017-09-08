package com.tocsyk.models;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private Address BranchAddress;
    private int BranchID;
    private List<Customer> CustomerCollection;

    public Branch(Address branchAddress) {
        try {
            setBranchID();
            BranchAddress = branchAddress;
            CustomerCollection = new ArrayList<Customer>();
        } catch (IllegalArgumentException aa) {
            System.out.println("Exception has been thrown:" + aa.toString());
            throw aa;
        }
    }


    public Address getBranchAddress() {
        return BranchAddress;
    }

    public void setBranchAddress(Address branchAddress) {
        BranchAddress = branchAddress;
    }

    public int getBranchID() {
        return BranchID;
    }

    private void setBranchID() {
        BranchID = Sequence.getBranchSeq();
    }

        /*
        public bool IsNull()
        {
            return this.BranchID == 0;
        }

        public virtual bool ReceivePayment(object payment)
        {
            throw new System.NotImplementedException();
        }
        */

}
