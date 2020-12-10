package com.tuananhdo.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFailureHanler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String email = request.getParameter("email");
        String failureRedireacURL = "/login?error";
        if (exception.getMessage().contains("OTP")){
            failureRedireacURL = "/login?otp=true&email="+email;
        }
        super.setDefaultFailureUrl(failureRedireacURL);
        super.onAuthenticationFailure(request, response, exception);
    }
}
