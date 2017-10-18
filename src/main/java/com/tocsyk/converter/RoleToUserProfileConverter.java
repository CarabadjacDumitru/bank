package com.tocsyk.converter;


import com.tocsyk.model.Role;
import com.tocsyk.service.ImplService.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleToUserProfileConverter implements Converter<Object, Role> {

    @Autowired
    RoleServiceImpl roleService;

    public Role convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        Role profile = roleService.getUserRoleByID(id);
        return profile;
    }

}