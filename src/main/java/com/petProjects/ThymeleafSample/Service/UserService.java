package com.petProjects.ThymeleafSample.Service;


import com.petProjects.ThymeleafSample.User.CrmUser;
import com.petProjects.ThymeleafSample.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

// this will be used by the DaoAuthenticationProvider in the demoSecurityConfig for authentication
public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);
    public void save(CrmUser crmUser);
}