package com.example.projectDemo.service;
import com.example.projectDemo.model.UsersModel;
import com.example.projectDemo.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepo) {
        this.userRepository = userRepo;
    }

    public UsersModel registerUSer(String login, String password, String email) {
        if (login == null && password == null) {
            return null;
        } else {
            UsersModel usersModel = new UsersModel();
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            return userRepository.save(usersModel);


        }
    }
    public UsersModel authenticate(String login,String password){
        return userRepository.findByLoginAndPassword(login,password).orElse(null);
    }
}


