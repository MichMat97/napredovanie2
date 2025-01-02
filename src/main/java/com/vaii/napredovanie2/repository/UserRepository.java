package com.vaii.napredovanie2.repository;

import com.vaii.napredovanie2.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query("update User u set u.name = :name, u.email = :email, u.password = :password where u.id = :id")
    void updateUser(@Param("id") Long id, @Param("name") String name, @Param("email") String email, @Param("password") String password);

    @Modifying
    @Transactional
    @Query("update User u set u.password = :password where u.id = :id")
    void updateUserPasswd(@Param("id") Long id, @Param("password") String password);

    @Modifying
    @Transactional
    @Query("delete from User u where u.email = :email")
    void deleteUser(@Param("email") String email);

    User findByEmail(String email);
}


