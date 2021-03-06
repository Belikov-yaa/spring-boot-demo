package ru.geekbrains.springbootdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.geekbrains.springbootdemo.entities.User;
import ru.geekbrains.springbootdemo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        String name = authentication.getName();
        User user = userService.findByUsername(name);
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("user", user);
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
    }
}
