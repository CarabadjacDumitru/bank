package com.tocsyk.DAO.ImplDAO;

import com.tocsyk.DAO.AbstractDAO.AbstractDAO;
import com.tocsyk.DAO.AbstractDAO.AbstractRoleDAO;
import com.tocsyk.model.Role;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDAO")
public class RoleDAOImpl extends AbstractDAO<Integer, Role> implements AbstractRoleDAO {

    static final Logger logger = Logger.getLogger(LoginDAOImpl.class);

    @Override
    public List<Role> getAllRoles() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("Role"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Role> roles = (List<Role>) criteria.list();
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
