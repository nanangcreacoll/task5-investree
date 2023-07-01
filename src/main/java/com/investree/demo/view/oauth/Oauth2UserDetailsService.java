package com.investree.demo.view.oauth;

import com.investree.demo.model.Users;
import com.investree.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Oauth2UserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findOneByUsername(username);
        if (null == users) {
            throw new UsernameNotFoundException(String.format("Username %s is not found", username));
        }
        return users;
    }

    @CacheEvict("username")
    public void clearCache(String s) {
        System.out.println("ini cache user_id= "+s);
    }
}
