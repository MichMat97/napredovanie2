package com.vaii.napredovanie2.service;

import com.vaii.napredovanie2.entity.Role;
import com.vaii.napredovanie2.entity.User;
import com.vaii.napredovanie2.repository.RoleRepository;
import com.vaii.napredovanie2.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
        return userDto;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

    @Transactional
    @Override
    public void updateUser(Long id, String name, String email, String password) {
        // Získaj existujúceho používateľa z databázy na základe jeho emailu
        User existingUser = userRepository.findByEmail(email);

        // Ak používateľ existuje, aktualizuj jeho informácie
        if (existingUser != null) {
            // Aktualizuj informácie o používateľovi
            // Ulož zmeny do databázy
            userRepository.updateUser(id, name, email, passwordEncoder.encode(password));
        } else {
            throw new EntityNotFoundException("User not found with email: " + email);
        }
    }

    @Transactional
    @Override
    public void deleteUser(String email) {
        // Získaj existujúceho používateľa z databázy na základe jeho emailu
        User existingUser = userRepository.findByEmail(email);

        // Ak používateľ existuje, aktualizuj jeho informácie
        if (existingUser != null) {
            // Aktualizuj informácie o používateľovi
            // Ulož zmeny do databázy
            userRepository.deleteUser(existingUser.getEmail());
        } else {
            throw new EntityNotFoundException("User not found with email: " + email);
        }
    }
}