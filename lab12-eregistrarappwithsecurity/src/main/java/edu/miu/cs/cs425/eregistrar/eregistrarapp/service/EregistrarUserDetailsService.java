package edu.miu.cs.cs425.eregistrar.eregistrarapp.service;


import edu.miu.cs.cs425.eregistrar.eregistrarapp.model.Role;
import edu.miu.cs.cs425.eregistrar.eregistrarapp.model.User;
import edu.miu.cs.cs425.eregistrar.eregistrarapp.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class EregistrarUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public EregistrarUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found"));
    }

    public User saveUser(User user){
        if(!userRepository.findByUsername(user.getUsername()).isPresent()){
            return userRepository.save(user);
        }
        return null;
    }

    public void saveUsers(List<User> users){
        for(User user:users){
            if(!userRepository.findByUsername(user.getUsername()).isPresent()){
                userRepository.save(user);
            }
        }
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User users = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Username" + username +  " not found"));
        return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(), getAuthorities(users));
    }
    private static Collection<? extends GrantedAuthority> getAuthorities(User users){
        String [] userRoles = users.getRoles().stream().map(Role::getName).toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(userRoles);}


}
