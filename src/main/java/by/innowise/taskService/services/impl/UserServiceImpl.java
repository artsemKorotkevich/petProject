package by.innowise.taskService.services.impl;

import by.innowise.taskService.entities.User;
import by.innowise.taskService.exception.UserAlreadyExistException;
import by.innowise.taskService.exception.UserNotFoundException;
import by.innowise.taskService.repositories.UserRepository;
import by.innowise.taskService.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if(userRepository.findByEmail(user.getEmail())!= null){
            throw new UserAlreadyExistException(String.format("User {%s} already exists", user.getEmail()));
        }

        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        User userById = userRepository.findUserById(id);
        if(userById == null){
            throw new UserNotFoundException(String.format("The user with this id = {%s} was not found", id));
        }
        return userById;
    }

    @Override
    public void delete(Long id) {
        User userById = userRepository.findUserById(id);
        if(userById == null){
            throw new UserNotFoundException(String.format("The user with this id = {%s} was not found", id));
        }
        userRepository.delete(userById);
    }

    @Override
    public User update(User user, Long id){
        User currentUser = userRepository.findUserById(id);
        if(currentUser != null){
            currentUser.setEmail(user.getEmail());
            currentUser.setName(user.getName());
            return userRepository.saveAndFlush(currentUser);
        }
        throw new UserNotFoundException(String.format("The user with this id = {%s} was not found", user.getId()));
    }
}
