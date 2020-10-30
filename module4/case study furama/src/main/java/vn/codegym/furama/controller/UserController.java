package vn.codegym.furama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import vn.codegym.furama.model.User;
import vn.codegym.furama.service.Impl.RoleServiceImpl;
import vn.codegym.furama.service.Impl.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userRepository;

    @Autowired
    private RoleServiceImpl roleRepository;

//    @RequestMapping(value = "/403", method = RequestMethod.GET)
//    public ModelAndView accessDenied(Model model) {
//            String message = "<script> alert('Hi "//
//                    + "! You do not have permission to access this page!')</script>";
//            model.addAttribute("message", message);
//        return new ModelAndView("/index","message",message);
//    }


    @RequestMapping(value = "/401", method = RequestMethod.GET)
    public String loginFail(Model model, @CookieValue(value = "remember-me", defaultValue = "")String remember, HttpServletResponse response) {
        if(remember.equals("login")) {
            Cookie cookie = new Cookie("remember-me",remember);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
        }else {
            remember = "";
            Cookie cookie = new Cookie("remember-me",remember);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
        }
        String message="";
        message = "sai mat khau";
        model.addAttribute("message", message);
        return "/index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model, @CookieValue(value = "remember-me", defaultValue = "") String remember, HttpServletResponse response) {
        remember = "login";
        Cookie cookie = new Cookie("remember-me",remember);
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
        String message="";
        message = remember;
        model.addAttribute("message", message);
        return "/index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, @CookieValue(value = "remember-me", defaultValue = "")String remember, HttpServletResponse response) {
        if(remember.equals("login")) {
            Cookie cookie = new Cookie("remember-me",remember);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
        }else {
            remember = "";
            Cookie cookie = new Cookie("remember-me",remember);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
        }
        String message="";
        message = remember;
        model.addAttribute("message", message);
        return "/index";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logout1(Model model, @CookieValue(value = "remember-me", defaultValue = "")String remember, HttpServletResponse response) {
        remember = "logout";
        Cookie cookie = new Cookie("remember-me",remember);
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
        String message="";
        message = remember;
        model.addAttribute("message", message);
        return "/index";
    }

    @PostMapping("/register")
    public ModelAndView viewRegister(@RequestParam("username") String username, @RequestParam("password") String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashPassword = encoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(hashPassword);
        user.setRole(roleRepository.findByRoleName("ROLE_USER"));
        userRepository.save(user);
        return new ModelAndView("/index");
    }

//    @GetMapping("/logoutSuccessful")
//    public ModelAndView logoutS(){
//        return new ModelAndView("/index");
//    }
}