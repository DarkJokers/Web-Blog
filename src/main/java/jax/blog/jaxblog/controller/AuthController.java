package jax.blog.jaxblog.controller;

import jax.blog.jaxblog.entity.User;
import jax.blog.jaxblog.repository.UserRepository;
import jax.blog.jaxblog.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        userRepository.save(user);
        String token = jwtService.generateToken(user.getEmail());
        return Map.of("message", "注册成功", "token", token);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        return jwtService.authenticate(email, password)
                .map(user -> Map.of(
                        "message", "登录成功",
                        "token", jwtService.generateToken(user.getEmail()),
                        "name", user.getName()
                ))
                .orElseGet(() -> Map.of("error", "邮箱或密码错误"));
    }

    @GetMapping("/me")
    public Object getMe(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        return jwtService.getUserFromToken(token)
                .map(user -> Map.of("email", user.getEmail(), "name", user.getName()))
                .orElseGet(() -> Map.of("error", "无效Token"));
    }
}
