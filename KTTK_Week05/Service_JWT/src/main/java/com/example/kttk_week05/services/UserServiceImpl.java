package com.example.kttk_week05.services;

import com.example.kttk_week05.models.Role;
import com.example.kttk_week05.models.User;
import com.example.kttk_week05.repository.RoleRepository;
import com.example.kttk_week05.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    @Override
    public User login(String username, String password) {
        return userRepository.login(username,password);
    }

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(username);
       if(user == null){
           throw new UsernameNotFoundException("User not found in the database");
       }else{
          System.out.println(username);
       }
       Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
       user.getRoles().forEach(role->{
           authorities.add(new SimpleGrantedAuthority(role.getName()));
       });
       return new UserDetails() {
           @Override
           public Collection<? extends GrantedAuthority> getAuthorities() {
               return authorities;
           }

           @Override
           public String getPassword() {
               return user.getPassword();
           }

           @Override
           public String getUsername() {
               return user.getUsername();
           }

           @Override
           public boolean isAccountNonExpired() {
               return false;
           }

           @Override
           public boolean isAccountNonLocked() {
               return false;
           }

           @Override
           public boolean isCredentialsNonExpired() {
               return false;
           }

           @Override
           public boolean isEnabled() {
               return false;
           }
       };
    }
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


}
