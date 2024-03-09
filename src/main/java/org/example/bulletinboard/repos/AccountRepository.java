package org.example.bulletinboard.repos;


import org.example.bulletinboard.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
