package org.example.bulletinboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Account {
    @Id
    @Size(min = 4, message = "아이디는 최소 4자 이상이어야 합니다.")
    private String id;
    @Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
    private String pw;
}
