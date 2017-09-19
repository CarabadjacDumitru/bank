package com.tocsyk.dao;


import com.tocsyk.models.Login;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("LoginDao")
public class LoginDAOImpl extends AbstractDao<Integer, Login> implements LoginDAO {

    static final Logger logger = LogManager.getLogger(LoginDAOImpl.class);

    public Login findById(int id) {
        Login Login = getByKey(id);
        if (Login != null) {
            Hibernate.initialize(Login.getRoles());
        }
        return Login;
    }

    public Login findBySSO(String sso) {
        logger.info("SSO :  " + sso.toString());
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        Login Login = (Login) crit.uniqueResult();
        if (Login != null) {
            Hibernate.initialize(Login.getRoles());
        }
        return Login;
    }

    @SuppressWarnings("unchecked")
    public List<Login> findAllLogins() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Login> Logins = (List<Login>) criteria.list();

        // No need to fetch LoginProfiles since we are not showing them on list page. Let them lazy load.
        // Uncomment below lines for eagerly fetching of LoginProfiles if you want.
        /*
		for(Login Login : Logins){
			Hibernate.initialize(Login.getLoginProfiles());
		}*/
        return Logins;
    }

    public void save(Login Login) {
        persist(Login);
    }

    public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        Login Login = (Login) crit.uniqueResult();
        delete(Login);
    }

}