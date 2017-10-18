package com.tocsyk.DAO.ImplDAO;

import com.tocsyk.DAO.AbstractDAO.AbstractDAO;
import com.tocsyk.DAO.AbstractDAO.AbstractRoleDAO;
import com.tocsyk.model.Role;
import com.tocsyk.model.enums.enumRoleType;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("roleDAO")
public class RoleDAOImpl extends AbstractDAO<Integer, Role> implements AbstractRoleDAO {

    static final Logger logger = Logger.getLogger(RoleDAOImpl.class);

    @Override
    public List<Role> getAllRoles() {
        //Criteria criteria = createEntityCriteria();
        //return (List<Role>)criteria.list();
        /*Criteria crit = createEntityCriteria();
        return (List<Role>)crit.list();*/

        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1, enumRoleType.ADMIN.getRole()));
        roles.add(new Role(2, enumRoleType.BANK.getRole()));
        roles.add(new Role(3, enumRoleType.BRANCH.getRole()));
        roles.add(new Role(4, enumRoleType.CUSTOMER.getRole()));
        roles.add(new Role(5, enumRoleType.CONTRACT.getRole()));
        roles.add(new Role(6, enumRoleType.PAYMENT.getRole()));
        return roles;
    }

    @Override
    public Role getUserRoleByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("LoginName", name));
        return  (Role)crit.uniqueResult();
    }

    @Override
    public Role getUserRoleByID(int ID) {
        return getByKey(ID);
    }
}
