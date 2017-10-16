package com.tocsyk.DAO.ImplDAO;

import com.tocsyk.DAO.AbstractDAO.AbstractDAO;
import com.tocsyk.DAO.AbstractDAO.AbstractLoginDAO;
import com.tocsyk.model.Login;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("loginDAO")
public class LoginDAOImpl extends AbstractDAO<Integer, Login> implements AbstractLoginDAO {

    static final Logger logger = Logger.getLogger(LoginDAOImpl.class);

    public Login getLoginById(int ID) {
        return getByKey(ID);
    }

    public Login getLoginByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("LoginName", name));
        return  (Login)crit.uniqueResult();
    }

    public void registerLogin(Login login) {
        persist(login);
    }

    public void updateLogin(Login login) {
        persist(login);
    }

    public void deleteLogin(Login login) {
        persist(login);
    }

    public List<Login> getAllLogins() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Login> logins = (List<Login>) criteria.list();
        return logins;
    }
}