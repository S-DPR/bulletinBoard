package org.example.bulletinboard.repos;

import org.example.bulletinboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<User, String> {
}
