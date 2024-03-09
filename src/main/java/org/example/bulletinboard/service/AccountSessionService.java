package org.example.bulletinboard.service;

import jakarta.servlet.http.HttpSession;
import org.example.bulletinboard.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountSessionService {
    private final HttpSession session;

    @Autowired
    AccountSessionService(HttpSession session) {
        this.session = session;
    }

    public Account getCurrentAccountSession() {
        return (Account) session.getAttribute("account");
    }

    public void setAccountSession(Account account) {
        session.setAttribute("account", account);
    }
}
