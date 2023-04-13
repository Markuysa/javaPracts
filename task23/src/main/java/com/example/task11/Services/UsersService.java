package com.example.task11.Services;

import com.example.task11.Entities.User;
import com.example.task11.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements UsersServiceInterface{
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findUserByName(username);
    }
    public boolean addUser(String login, String password){
        var user = usersRepository.findUserByName(login);
        if (user==null){
            return false;
        }
        usersRepository.save(new User(login,password));
        return true;
    }
    public User findUser(String username){
        return usersRepository.findUserByName(username);
    }
    public void remove(String login){
        usersRepository.delete(findUser(login));
    }
    public List<User> getAll(){
        return  usersRepository.findAll();
    }
}
