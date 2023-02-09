package com.codewithloyiso.C3app.Repositories;

import com.codewithloyiso.C3app.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
  User findByEmailAndPassword(String email, String password);

}