package alex.tir.storage.impl;

import alex.tir.storage.entity.Role;
import alex.tir.storage.entity.User;
import alex.tir.storage.repository.UserRepository;
import alex.tir.storage.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepo;
    PasswordEncoder passwordEncoder;
    @Override
    public Mono<User> getByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public Mono<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public Mono<User> registerUser(User user) {
        return userRepo.save(
                user.toBuilder()
                        .password(passwordEncoder.encode(user.getPassword()))
                        .role(Role.USER)
                        .enabled(true)
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build()
        ).doOnSuccess(u -> {
            log.info("In registerUser - user: {} created", u);
        });
    }
}
