package org.example.bulletinboard.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bulletinboard.model.Account;
import org.example.bulletinboard.service.AccountSessionService;
import org.springframework.web.servlet.HandlerInterceptor;

public class SessionInterceptor implements HandlerInterceptor {
    private final AccountSessionService accountSessionService;

    public SessionInterceptor(AccountSessionService accountSessionService) {
        this.accountSessionService = accountSessionService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Account currentAccount = accountSessionService.getCurrentAccountSession();
        if (currentAccount == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
