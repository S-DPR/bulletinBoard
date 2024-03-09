package org.example.bulletinboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

@Setter
@Getter
@Entity
public class User {
    @Id
    private String id;
    private String password;
}
