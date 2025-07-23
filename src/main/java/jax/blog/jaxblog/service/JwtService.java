package jax.blog.jaxblog.service;

import jax.blog.jaxblog.entity.User;
import jax.blog.jaxblog.repository.UserRepository;
import jax.blog.jaxblog.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    public Optional<User> authenticate(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
            return userOpt;
        }
        return Optional.empty();
    }

    public String generateToken(String email) {
        return jwtUtils.generateToken(email);
    }

    public Optional<User> getUserFromToken(String token) {
        if (jwtUtils.validateToken(token)) {
            String email = jwtUtils.getEmailFromToken(token);
            return userRepository.findByEmail(email);
        }
        return Optional.empty();
    }
}
