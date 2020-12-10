package com.tuananhdo.security;

import com.tuananhdo.entity.User;
import com.tuananhdo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Component
public class BeforeAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    @Autowired
    private UserService userService;

   public BeforeAuthenticationFilter(){
        super.setUsernameParameter("email");
        super.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login","POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String email = request.getParameter("email");
        System.out.println("atempAuthentication email : " + email);
        User user = userService.getUserByEmail(email);
            if (user !=null){
                float spamScore = getGoogleRecaptchaScore();
                if (spamScore < 0.5){
                    if (user.isOTPRequired()){
                        return super.attemptAuthentication(request, response);
                    }
                    try {
                        userService.generateOneTimePassword(user);
                        throw new InsufficientAuthenticationException("OTP");
                    }catch (MessagingException | UnsupportedEncodingException ex){
                        throw new AuthenticationServiceException("Lỗi gửi OTP đến email của bạn");

                    }
                }
            }
        return super.attemptAuthentication(request, response);
    }

    private float getGoogleRecaptchaScore() {
       return 0.43f;
    }

    @Autowired
    @Override
    public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler successHandler) {
        super.setAuthenticationSuccessHandler(successHandler);
    }

    @Autowired
    @Override
    public void setAuthenticationFailureHandler(AuthenticationFailureHandler failureHandler) {
        super.setAuthenticationFailureHandler(failureHandler);
    }

    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }


}
