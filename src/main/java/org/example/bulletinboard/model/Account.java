package org.example.bulletinboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Account {
    @Id
    private String id;
    private String pw;
}
