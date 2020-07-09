package com.petProjects.ThymeleafSample.dao;

import com.petProjects.ThymeleafSample.entity.Role;

public interface RoleDao {
    public Role findRoleByName(String theRoleName);

}
