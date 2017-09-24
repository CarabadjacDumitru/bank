package com.tocsyk.converters;


import com.tocsyk.models.Role;
import com.tocsyk.services.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class RoleToUserProfileConverter implements Converter<Object, Role> {

    //static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);
    static final Logger logger = Logger.getLogger(RoleToUserProfileConverter.class);

    @Autowired
    RoleService roleService;

    public Role convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        Role role = roleService.findById(id);
        //logger.info("Roleeee : {}", role);
        return role;
    }

}