//package com.tuananhdo.security;
//
//import com.tuananhdo.entity.User;
//import com.tuananhdo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//@Component
//public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//    @Autowired
//    private UserService userService;
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        System.out.println("đăng nhập thành công");
//        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
//        User user = userDetails.getMyUserDetail();
//
//        if (user.isOTPRequired()){
//            userService.clearOTP(user);
//        }
//        super.onAuthenticationSuccess(request, response, authentication);
//    }
//}
