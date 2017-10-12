package com.tocsyk.daoImp;

import com.tocsyk.dao.BankDAO;
import com.tocsyk.models.Bank;
import com.tocsyk.models.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.List;

public class BankDAOImpl extends JdbcDaoSupport implements BankDAO  {

    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    public BankDAOImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }


    @Override
    public List<Branch> findAllBranches() {

        return null;
    }

    @Override
    public void registerBank(Bank bank) {

    }

    @Override
    public Bank loadBankData(String bankName) {
        return null;
    }
}
